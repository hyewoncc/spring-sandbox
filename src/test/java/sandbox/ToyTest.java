package sandbox;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ToyTest {

    @DisplayName("통과하지 않는 테스트")
    @Test
    void test_fail() {
        int i = 1;
        assertThat(i).isEqualTo(2);
    }

    @DisplayName("통과하는 테스트")
    @Test
    void test_success() {
        int j = 1;
        assertThat(j).isEqualTo(1);
    }
}
