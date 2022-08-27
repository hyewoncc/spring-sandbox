package sandbox.application.posting;

import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sandbox.application.EventService;
import sandbox.application.Events;
import sandbox.domain.Post;
import sandbox.domain.PostRepository;

@Transactional
@Service
public class PostingEditService implements EventService {

    private final PostRepository posts;

    public PostingEditService(final PostRepository posts) {
        this.posts = posts;
    }

    @Override
    public void execute(final Map<String, Object> requestBody) {
        Map<String, Object> posting = (Map<String, Object>) ((Map<String, Object>) requestBody.get("content")).get("posting");

        Long id = (Long) posting.get("id");
        Post post = posts.findById(id)
                .orElseThrow(NoSuchElementException::new);
        String text = (String) posting.get("text");

        post.editText(text);
    }

    @Override
    public boolean isSameEvent(final Events event) {
        return Events.POSTING_EDIT == event;
    }
}
