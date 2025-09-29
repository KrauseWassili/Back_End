package de.aittr.user.controllers;

import de.aittr.user.dto.UserRequestDto;
import de.aittr.user.dto.UserResponseDto;
import de.aittr.user.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class UserController {
    private static Long lastId = 4L;
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
        USERS.put(1L,new User(1L, "Nick", "nick@mail.com","qwe1"));
        USERS.put(2L,new User(2L, "Jack", "jack@mail.com","qwe2"));
        USERS.put(3L,new User(3L, "Ann", "ann@mail.com","qwe3"));
        USERS.put(4L,new User(4L, "Lena", "lena@mail.com", "qwe4"));
        System.out.println(USERS);
    }

    // localhost:8080/users
    // localhost:8080/users?sort=name
    // localhost:8080/users?sort=email
    // localhost:8080/users?sort=email&qwe=1


    @GetMapping("/users")
    //public List<UserResponseDto> getUsers(@RequestParam (name = "sort", required = false) String sortType){
    public List<UserResponseDto> getUsers(@RequestParam (name = "sort", defaultValue = "") String sortType){
        //@RequestParam(name = "sort") String sort
        //String sort = "";
        System.out.println("----------------------------------------------");
        System.out.println(USERS);

        List<UserResponseDto> result = USERS.entrySet().stream()
                //.map(e->e.getValue())
                .map(Map.Entry::getValue)
                .map(u -> new UserResponseDto(u.getId(), u.getName(), u.getEmail()))
                .toList();
        result = new ArrayList<>(result);
        if (sortType == null || sortType.isBlank()){
            return result;
        }
        if (sortType.equals("name")) {
            result.sort((u1,u2)-> u1.getName().compareTo(u2.getName()));
            return result;
        } else if (sortType.equals("email")) {
            result.sort((u1,u2)-> u1.getEmail().compareTo(u2.getEmail()));
            return result;
        } else {
            return result;
        }

    }


    @GetMapping("/users/{id}")
    public UserResponseDto getUserById(@PathVariable Long id){
        User user = USERS.get(id);
        return new UserResponseDto(user.getId(), user.getName(), user.getEmail());
    }

    //!!! Не рабочий маппинг
    // localhost:8080/users/1/friends/3
    @GetMapping("/users/{id}/friends/{friendID}")
    public User getUserById(@PathVariable Long id, @PathVariable(name= "friendID") Long friendId){
        return USERS.get(id);
    }

    @PostMapping("/users")
    public UserResponseDto newUser(@RequestBody UserRequestDto userDto){
        User user = new User(++lastId, userDto.getName(), userDto.getEmail(), userDto.getPassword());
        USERS.put(lastId, user);

        return new UserResponseDto(user.getId(), userDto.getName(), userDto.getEmail());
    }



}
