package de.aittr.demo1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/start")
    public String start(){
        return "hello.html";
    }
}
