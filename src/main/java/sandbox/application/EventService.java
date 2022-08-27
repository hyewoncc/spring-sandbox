package sandbox.application;

import java.util.Map;

public interface EventService {

    void execute(Map<String, Object> requestBody);

    boolean isSameEvent(Events event);
}
