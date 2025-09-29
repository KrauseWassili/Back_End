package de.aittr.code.controllers;

import de.aittr.code.dto.UserRequestDto;
import de.aittr.code.dto.UserResponseDto;
import de.aittr.code.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static java.util.stream.Collectors.toList;

@RestController
public class UserController {
    private static Long lastId = 4L;

    private static final Map<Long, User> USERS = new HashMap<>();

    static {
        USERS.put(1L, new User(1L,"Peter", "a.peter@web.de", "12345"));
        USERS.put(2L, new User(2L,"Anna", "t.anna@web.de", "23456"));
        USERS.put(3L, new User(3L,"Stefan", "m.stefan@web.de", "34567"));
        USERS.put(4L, new User(4L,"Maria", "b.maria@web.de", "45678"));
    }


    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDto>> getUser(
            @RequestParam(name = "sort", defaultValue = "") String sortType
    ) {
        List<UserResponseDto> usersResponseDto = USERS.entrySet().stream()
                .map(Map.Entry::getValue)
                .map(u -> new UserResponseDto(u.getId(), u.getEmail(), u.getName()))
                .toList();

        usersResponseDto = new ArrayList<>(usersResponseDto);
        if (sortType.equals("email")) {
            usersResponseDto.sort((u1,u2) -> u1.getEmail().compareTo(u2.getEmail()));
        } else if (sortType.equals("name")) {
            usersResponseDto.sort((u1,u2)-> u1.getName().compareTo(u2.getName()));
        }

        return ResponseEntity.status(HttpStatus.OK).body(usersResponseDto);

    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable long id) {
        User user = USERS.get(id);
        UserResponseDto userResponseDto = new UserResponseDto(id, user.getEmail(), user.getName());
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }

    @PostMapping("/users")
    public ResponseEntity<UserResponseDto> addUser(@RequestBody UserRequestDto userRequestDto) {
        USERS.put(++lastId, new User(lastId,userRequestDto.getEmail(), userRequestDto.getName(), userRequestDto.getPassword()));

        UserResponseDto userResponseDto = new UserResponseDto(lastId, userRequestDto.getEmail(), userRequestDto.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDto);
    }


}
