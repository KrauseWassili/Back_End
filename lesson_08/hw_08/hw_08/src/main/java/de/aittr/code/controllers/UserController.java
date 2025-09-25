package de.aittr.code.controllers;

import de.aittr.code.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {


    private static final List<User> USERS = List.of(
            new User("Peter", "peter@web.de"),
            new User("Anna", "anna@web.de"),
            new User("Stefan", "stefan@web.de"),
            new User("Maria", "maria@web.de"),
            new User("Pavel", "pavel@web.de")
    );

    @GetMapping("/users")
    public List<User> getUsers() {
        return USERS;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id) {
        for (User user : USERS) {
            if (user.getId() == id) {
                return user;
            }
        }
        User emptyUser = new User("N/A", "N/A");
        emptyUser.setId(0);
        return emptyUser;
    }

}
