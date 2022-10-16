package sandbox;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UppercaseHandler implements InvocationHandler {

    private final Object target;

    public UppercaseHandler(final Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
        Object result = method.invoke(target, args);
        if (result instanceof String && method.getName().startsWith("say")) {
            return ((String) result).toUpperCase();
        }
        return result;
    }
}
