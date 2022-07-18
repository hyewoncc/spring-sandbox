package sandbox;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToyController {

    @Value("${bot-token}")
    private String token;

    @GetMapping
    public void main() {
    }

    @GetMapping("/hello")
    public ToyResponse sayHello() {
        return new ToyResponse("hello");
    }

    @GetMapping("/token")
    public TokenResponse takeToken() {
        return new TokenResponse(token);
    }
}
