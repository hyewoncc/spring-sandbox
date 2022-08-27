package sandbox.ui;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sandbox.application.EventServiceFinder;
import sandbox.application.Events;

@RestController
@RequestMapping("/event")
public class EventController {

    private final EventServiceFinder serviceFinder;

    public EventController(final EventServiceFinder serviceFinder) {
        this.serviceFinder = serviceFinder;
    }

    @PostMapping
    public ResponseEntity<Void> execute(final Map<String, Object> request) {
        serviceFinder.findByEvent(Events.of(request))
                .execute(request);
        return ResponseEntity.noContent().build();
    }
}
