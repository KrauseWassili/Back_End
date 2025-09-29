package de.aittr.server_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerDemo {

    @GetMapping
    public String hello() {
        return "hello";
    }

}
