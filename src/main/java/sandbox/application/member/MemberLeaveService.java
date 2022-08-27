package sandbox.application.member;

import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sandbox.application.EventService;
import sandbox.application.Events;
import sandbox.domain.MemberRepository;

@Transactional
@Service
public class MemberLeaveService implements EventService {

    private final MemberRepository members;

    public MemberLeaveService(final MemberRepository members) {
        this.members = members;
    }

    @Override
    public void execute(final Map<String, Object> requestBody) {
        Long id = (Long) ((Map<String, Object>) requestBody.get("content")).get("id");
        members.deleteById(id);
    }

    @Override
    public boolean isSameEvent(final Events event) {
        return Events.MEMBER_LEAVE == event;
    }
}
