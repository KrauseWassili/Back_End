package de.aittr.user.controllers;

import de.aittr.user.dto.UserRequestDto;
import de.aittr.user.dto.UserResponseDto;
import de.aittr.user.mapper.UserMapper;

import de.aittr.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin
@RestController
public class UserController {

    private final UserMapper mapper;
    private final UserService service;

    public UserController(UserMapper mapper, UserService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDto>> getUsers(@RequestParam (name = "sort", defaultValue = "") String sortType){
        if (sortType.equals("name")){
            return ResponseEntity.status(HttpStatus.OK).body(service.getAllUsersOrderedByName());
        } else if (sortType.equals("email")) {
            return ResponseEntity.status(HttpStatus.OK).body(service.getAllUsersOrderedByEmail());
        }
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllUsers());
    }

    /*


    // localhost:8080/users
    // localhost:8080/users?sort=name
    // localhost:8080/users?sort=email
    // localhost:8080/users?sort=email&qwe=1


    @GetMapping("/users")
    //public List<UserResponseDto> getUsers(@RequestParam (name = "sort", required = false) String sortType){
    public ResponseEntity<List<UserResponseDto>> getUsers(@RequestParam (name = "sort", defaultValue = "") String sortType){


        List<UserResponseDto> result = USERS.entrySet().stream()
                //.map(e->e.getValue())
                .map(Map.Entry::getValue)
                //.map(u -> new UserResponseDto(u.getId(), u.getName(), u.getEmail()))
                .map(mapper::toResponseDto)
                .toList();
        result = new ArrayList<>(result);
        if (sortType == null || sortType.isBlank()){
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }
        if (sortType.equals("name")) {
            result.sort((u1,u2)-> u1.getName().compareTo(u2.getName()));
        } else if (sortType.equals("email")) {
            result.sort((u1,u2)-> u1.getEmail().compareTo(u2.getEmail()));
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }


    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long id){
        User user = USERS.get(id);
        UserResponseDto result = new UserResponseDto(user.getId(), user.getName(), user.getEmail());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    //!!! Не рабочий маппинг
    // localhost:8080/users/1/friends/3
    @GetMapping("/users/{id}/friends/{friendID}")
    public User getUserById(@PathVariable Long id, @PathVariable(name= "friendID") Long friendId){
        return USERS.get(id);
    }

    @PostMapping("/users")
    public ResponseEntity<UserResponseDto> newUser(@RequestBody UserRequestDto userDto){
        User user = new User(++lastId, userDto.getName(), userDto.getEmail(), userDto.getPassword());
        USERS.put(lastId, user);

        UserResponseDto result = new UserResponseDto(user.getId(), userDto.getName(), userDto.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/service")
    public  String test(){
        service.print();
        return "Service is work!";
    }

    */

}
