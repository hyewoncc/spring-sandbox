package sandbox.application;

import java.util.Arrays;
import java.util.Map;
import java.util.NoSuchElementException;

public enum Events {

    MEMBER_JOIN("member", "join"),
    MEMBER_LEAVE("member", "leave"),

    POSTING_WRITE("posting", "write"),
    POSTING_EDIT("posting", "edit"),
    POSTING_DELETE("posting", "delete"),
    ;

    private final String event;
    private final String subtype;

    Events(final String event, final String subtype) {
        this.event = event;
        this.subtype = subtype;
    }

    public static Events of(final Map<String, Object> requestBody) {
        String event = String.valueOf(requestBody.get("event"));
        String type = (String) ((Map<String, Object>) requestBody.get("content")).get("type");

        return Arrays.stream(values())
                .filter(events -> isSameEvent(events, event, type))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    private static boolean isSameEvent(final Events events, final String event, final String type) {
        return events.event.equals(event) && events.subtype.equals(type);
    }

    public String getEvent() {
        return event;
    }

    public String getSubtype() {
        return subtype;
    }
}
