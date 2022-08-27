package sandbox.application.posting;

import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sandbox.application.EventService;
import sandbox.application.Events;
import sandbox.domain.PostRepository;

@Transactional
@Service
public class PostingDeleteService implements EventService {

    private final PostRepository posts;

    public PostingDeleteService(final PostRepository posts) {
        this.posts = posts;
    }

    @Override
    public void execute(final Map<String, Object> requestBody) {
        Long id = (Long) ((Map<String, Object>) requestBody.get("content")).get("id");
        posts.deleteById(id);
    }

    @Override
    public boolean isSameEvent(final Events event) {
        return Events.POSTING_DELETE == event;
    }
}
