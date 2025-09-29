package de.aittr.code.controllers;

import de.aittr.code.dto.UserResponseDto;
import de.aittr.code.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class UserController {


    private static final List<User> USERS = new ArrayList(List.of(
            new User("Peter", "a.peter@web.de", "12345"),
            new User("Anna", "t.anna@web.de", "23456"),
            new User("Stefan", "m.stefan@web.de", "34567"),
            new User("Maria", "b.maria@web.de", "45678"),
            new User("Pavel", "k.pavel@web.de", "56789")
    ));


    @GetMapping("/users")
    public List<UserResponseDto> getUser() {
        return USERS.stream()
                .map(u -> new UserResponseDto(u.getId(), u.getEmail(), u.getName()))
                .toList();
    }

    @GetMapping("/users/{id}")
    public UserResponseDto getUser(@PathVariable long id) {
        return USERS.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .map(u -> new UserResponseDto(id, u.getEmail(), u.getName()))
                .get();
    }

    @PostMapping("/users")
    public UserResponseDto addUser(@RequestBody User user) {
        USERS.add(user);
        return new UserResponseDto(user.getId(), user.getEmail(), user.getName());
    }

    @GetMapping("usersSorted")
    public List<UserResponseDto> getUser(
            @RequestParam(defaultValue = "name") String sortBy
    ) {
        if (sortBy.equals("email"))
            return USERS.stream()
                    .sorted(Comparator.comparing(User::getEmail))
                    .map(u -> new UserResponseDto(u.getId(), u.getEmail(), u.getName()))
                    .toList();
        else
            return USERS.stream()
                    .sorted(Comparator.comparing(User::getName))
                    .map(u -> new UserResponseDto(u.getId(), u.getEmail(), u.getName()))
                    .toList();

    }

}
