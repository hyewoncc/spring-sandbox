package sandbox;

public class ToyResponse {
    private String text;

    private ToyResponse() {
    }

    public ToyResponse(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
