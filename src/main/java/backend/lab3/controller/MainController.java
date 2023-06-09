package backend.lab3.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.concurrent.atomic.AtomicLong;
import backend.lab3.response.GreetingResponse;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
public class MainController {
    @CrossOrigin(origins = "*")
    @RequestMapping("/hello")
    public String index() {
        return "Hello, World!";
    }

    private final AtomicLong counter = new AtomicLong();

    @CrossOrigin(origins = "*")
    @RequestMapping("/greeting")
    public @ResponseBody GreetingResponse greeting(@RequestParam(value = "name",
            defaultValue = "World") String name) {
        return new GreetingResponse(counter.incrementAndGet(), "Hello, " + name + "!");
    }
}

