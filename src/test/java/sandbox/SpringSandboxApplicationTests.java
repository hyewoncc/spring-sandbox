package sandbox;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringSandboxApplicationTests {

	@Test
	void contextLoads() {
	}

	@DisplayName("성공하는 테스트")
	@Test
	void test_successCase () {
		assertThat(2).isEqualTo(2);
	}

}
