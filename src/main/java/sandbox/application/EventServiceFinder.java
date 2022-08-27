package sandbox.application;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Component;

@Component
public class EventServiceFinder {

    public final List<EventService> eventServices;

    public EventServiceFinder(final List<EventService> eventServices) {
        this.eventServices = eventServices;
    }

    public EventService findByEvent(final Events events) {
        return eventServices.stream()
                .filter(service -> service.isSameEvent(events))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }
}
