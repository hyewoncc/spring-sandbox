package sandbox;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToyController {

    @GetMapping
    public void main() {
    }

    @GetMapping("/hello")
    public void sayHello() {
        return new ToyResponse("hello");
    }
}
