package de.aittr.code.controllers;

import de.aittr.code.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {


    private static final List<User> USERS = new ArrayList(List.of(
            new User("Peter", "peter@web.de", "12345"),
            new User("Anna", "anna@web.de", "23456"),
            new User("Stefan", "stefan@web.de", "34567"),
            new User("Maria", "maria@web.de", "45678"),
            new User("Pavel", "pavel@web.de", "56789")
    ));

    @GetMapping("/users")
    public List<User> getUsers() {
        return USERS;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id) {
        USERS.stream()
                .filter(u-> u.getUser(id))
    }

}
