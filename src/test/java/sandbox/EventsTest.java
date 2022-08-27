package sandbox;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.TestConstructor.AutowireMode;
import sandbox.domain.Member;
import sandbox.domain.MemberRepository;
import sandbox.domain.Post;
import sandbox.domain.PostRepository;
import sandbox.ui.EventController;

@TestConstructor(autowireMode = AutowireMode.ALL)
@SpringBootTest
class EventsTest {

    private final EventController eventController;
    private final MemberRepository members;
    private final PostRepository posts;

    EventsTest(final EventController eventController, final MemberRepository members,
               final PostRepository posts) {
        this.eventController = eventController;
        this.members = members;
        this.posts = posts;
    }

    @DisplayName("회원 가입")
    @Test
    void memberJoin() {
        Map<String, Object> request =
                Map.of(
                        "event", "member",
                        "content", Map.of(
                                "type", "join",
                                "name", "cat"
                        )
                );
        eventController.execute(request);

        assertThat(members.existsByName("cat")).isTrue();
    }

    @DisplayName("회원 탈퇴")
    @Test
    void memberLeave() {
        Member dog = members.save(new Member("dog"));

        Map<String, Object> request =
                Map.of(
                        "event", "member",
                        "content", Map.of(
                                "type", "leave",
                                "id", dog.getId()
                        )
                );
        eventController.execute(request);

        assertThat(members.existsByName("dog")).isFalse();
    }
    
    @DisplayName("포스팅 작성")
    @Test
    void postingWrite() {
        Member bird = members.save(new Member("bird"));

        Map<String, Object> request =
                Map.of(
                        "event", "posting",
                        "content", Map.of(
                                "type", "write",
                                "posting", Map.of(
                                        "memberId", bird.getId(),
                                        "text", "안녕하세요"
                                )
                        )
                );
        eventController.execute(request);

        assertThat(posts.findAllByMember(bird)).hasSize(1);
    }

    @DisplayName("포스팅 수정")
    @Test
    void postingEdit() {
        Member cow = members.save(new Member("cow"));
        Post post = posts.save(new Post(cow, "반갑습니다"));

        Map<String, Object> request =
                Map.of(
                        "event", "posting",
                        "content", Map.of(
                                "type", "edit",
                                "posting", Map.of(
                                        "id", post.getId(),
                                        "text", "안녕하세요, 반갑습니다"
                                )
                        )
                );
        eventController.execute(request);

        assertThat(posts.findById(post.getId()).get().getText()).isEqualTo("안녕하세요, 반갑습니다");
    }

    @DisplayName("포스팅 삭제")
    @Test
    void postingDelete() {
        Member turtle = members.save(new Member("turtle"));
        Post post = posts.save(new Post(turtle, "내일 또 봐요"));

        Map<String, Object> request =
                Map.of(
                        "event", "posting",
                        "content", Map.of(
                                "type", "delete",
                                "id", post.getId()
                        )
                );
        eventController.execute(request);

        assertThat(posts.findAllByMember(turtle)).hasSize(0);
    }
}
