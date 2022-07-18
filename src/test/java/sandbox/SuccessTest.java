package sandbox;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SuccessTest {

    @DisplayName("성공하는 테스트 1")
    @Test
    void test_success_case_1() {
        int x = 1;

        assertThat(x).isEqualTo(1);
    }

    @DisplayName("성공하는 테스트 2")
    @Test
    void test_success_case_2() {
        int x = 2;

        assertThat(x).isEqualTo(2);
    }

    @DisplayName("실패하는 테스트 1")
    @Test
    void test_fail_case_1() {
        int x = 2;

        assertThat(x).isEqualTo(1);
    }
}
