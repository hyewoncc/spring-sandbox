package sandbox;

public class HelloUpperCase implements Hello {

    private final Hello hello;

    public HelloUpperCase(final Hello hello) {
        this.hello = hello;
    }

    @Override
    public String sayHello(final String name) {
        return hello.sayHello(name).toUpperCase();
    }

    @Override
    public String sayHi(final String name) {
        return hello.sayHi(name).toUpperCase();
    }

    @Override
    public String sayThankyou(final String name) {
        return hello.sayThankyou(name).toUpperCase();
    }

    @Override
    public String repeat(final String name) {
        return name;
    }
}
