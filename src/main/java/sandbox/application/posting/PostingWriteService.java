package sandbox.application.posting;

import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sandbox.application.EventService;
import sandbox.application.Events;
import sandbox.domain.Member;
import sandbox.domain.MemberRepository;
import sandbox.domain.Post;
import sandbox.domain.PostRepository;

@Transactional
@Service
public class PostingWriteService implements EventService {

    private final MemberRepository members;
    private final PostRepository posts;

    public PostingWriteService(final MemberRepository members, final PostRepository posts) {
        this.members = members;
        this.posts = posts;
    }

    @Override
    public void execute(final Map<String, Object> requestBody) {
        Map<String, Object> posting = (Map<String, Object>) ((Map<String, Object>) requestBody.get("content")).get("posting");

        Long memberId = (Long) posting.get("memberId");
        Member member = members.findById(memberId)
                .orElseThrow(NoSuchElementException::new);
        String text = (String) posting.get("text");

        posts.save(new Post(member, text));
    }

    @Override
    public boolean isSameEvent(final Events event) {
        return Events.POSTING_WRITE == event;
    }
}
