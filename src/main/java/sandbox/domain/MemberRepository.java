package sandbox.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public class MemberRepository implements JpaRepository<Member, Long> {
}
