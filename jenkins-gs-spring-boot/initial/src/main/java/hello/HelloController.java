package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
public class HelloController {

    @CrossOrigin()
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
