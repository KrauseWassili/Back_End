package de.aittr.user.controllers;

import de.aittr.user.model.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class UserController {
    /*
    private static final Map<Long, User> USERS = Map.of(
            1L,new User(1L, "Nick", "nick@mail.com"),
            2L,new User(2L, "Jack", "jack@mail.com"),
            3L,new User(3L, "Jeff", "jeff@mail.com")
    );

     */
    private static final Map<Long, User> USERS = new HashMap<>();
    static {
        System.out.println("Инициализируем map, имитация Базы данных");
        USERS.put(1L,new User(1L, "Nick", "nick@mail.com"));
        USERS.put(2L,new User(2L, "Jack", "jack@mail.com"));
        USERS.put(3L,new User(3L, "Ann", "ann@mail.com"));
        USERS.put(4L,new User(4L, "Lena", "lena@mail.com"));
        System.out.println(USERS);
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return USERS.entrySet().stream()
                //.map(e->e.getValue())
                .map(Map.Entry::getValue)
                .toList();
    }


    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id){
        return USERS.get(id);
    }

    // localhost:8080/users/1/friends/3
    @GetMapping("/users/{id}/friends/{friendID}")
    public User getUserById(@PathVariable Long id, @PathVariable(name= "friendID") Long friendId){
        return USERS.get(id);
    }



}
