package sandbox.application.member;

import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sandbox.application.EventService;
import sandbox.application.Events;
import sandbox.domain.Member;
import sandbox.domain.MemberRepository;

@Transactional
@Service
public class MemberJoinService implements EventService {

    private final MemberRepository members;

    public MemberJoinService(final MemberRepository members) {
        this.members = members;
    }

    @Override
    public void execute(final Map<String, Object> requestBody) {
        String name = (String) ((Map<String, Object>) requestBody.get("content")).get("name");
        members.save(new Member(name));
    }

    @Override
    public boolean isSameEvent(final Events event) {
        return Events.MEMBER_JOIN == event;
    }
}
