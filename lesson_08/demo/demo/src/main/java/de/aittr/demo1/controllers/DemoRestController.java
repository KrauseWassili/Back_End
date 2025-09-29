package de.aittr.demo1.controllers;

import de.aittr.demo1.controllers.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class DemoRestController {

    private Person admin = new Person("Jack",30);

    @GetMapping("/admin")
    public Person getAdminInfo(){
        return admin;
    }

    @GetMapping("/time")
    public String getTime(){
        LocalDateTime now = LocalDateTime.now();
        return now.toString();
    }
}
