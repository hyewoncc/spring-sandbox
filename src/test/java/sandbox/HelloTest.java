package sandbox;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Proxy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HelloTest {

    @DisplayName("프록시를 사용하지 않을 때, 문장 그대로 출력")
    @Test
    void hello() {
        final var hello = new HelloTarget();
        assertThat(hello.sayHello("cat")).isEqualTo("Hello cat");
        assertThat(hello.sayHi("dog")).isEqualTo("Hi dog");
        assertThat(hello.sayThankyou("bird")).isEqualTo("Thank You bird");
    }

    @DisplayName("프록시를 사용할 때, 대문자 문장 출력")
    @Test
    void helloProxyToUpperCase() {
        final var hello = new HelloUpperCase(new HelloTarget());
        assertThat(hello.sayHello("cat")).isEqualTo("HELLO CAT");
        assertThat(hello.sayHi("dog")).isEqualTo("HI DOG");
        assertThat(hello.sayThankyou("bird")).isEqualTo("THANK YOU BIRD");
    }

    @DisplayName("다이나믹 프록시를 사용한 대문자 문장 출력")
    @Test
    void helloDynamicProxyToUpperCase() {
        final var hello = (Hello) Proxy.newProxyInstance(
                getClass().getClassLoader(),
                new Class[]{Hello.class},
                new UppercaseHandler(new HelloTarget()));

        assertThat(hello.sayHello("cat")).isEqualTo("HELLO CAT");
        assertThat(hello.sayHi("dog")).isEqualTo("HI DOG");
        assertThat(hello.sayThankyou("bird")).isEqualTo("THANK YOU BIRD");
    }
}
