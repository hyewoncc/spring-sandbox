package sandbox.ui;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SessionController {

    private static final String SESSION_KEY = "chicks";

    @GetMapping
    public ModelAndView main(HttpSession session) {
        Object attribute = session.getAttribute(SESSION_KEY);
        ModelAndView modelAndView = new ModelAndView("session.html");
        Map<String, Object> map = new HashMap<>();

        if (attribute != null) {
            map.put(SESSION_KEY, (int) attribute);
            session.setAttribute(SESSION_KEY, (int) attribute);
            return modelAndView.addAllObjects(map);
        }

        map.put(SESSION_KEY, 0);
        session.setAttribute(SESSION_KEY, 0);
        return modelAndView.addAllObjects(map);
    }

    @PostMapping
    public String add(HttpSession session) {
        Object attribute = session.getAttribute(SESSION_KEY);

        if (attribute != null) {
            session.setAttribute(SESSION_KEY, (int) attribute + 1);
        }

        return "redirect:/";
    }
}
