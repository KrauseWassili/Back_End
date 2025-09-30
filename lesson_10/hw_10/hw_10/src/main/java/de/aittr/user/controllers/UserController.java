package de.aittr.user.controllers;

import de.aittr.user.dto.UserResponseDto;
import de.aittr.user.mapper.UserMapper;
import de.aittr.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequiredArgsConstructor
@CrossOrigin
@RestController
public class UserController {

    private final UserMapper mapper;
    private final UserService service;


    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDto>> getUsers(@RequestParam (name = "sort", defaultValue = "") String sortType){
        if (sortType.equals("email")) {
            return ResponseEntity.status(HttpStatus.OK).body(service.getAllUsersOrderedByEmail());
        } else if (sortType.equals("name")) {
            return ResponseEntity.status(HttpStatus.OK).body(service.getAllUsersOrderedByName());
        }
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllUsers());
    }
/*
    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDto>> getUser(
            @RequestParam(name = "sort", defaultValue = "") String sortType
    ) {
        List<UserResponseDto> usersResponseDto = USERS.entrySet().stream()
                .map(Map.Entry::getValue)
                //.map(u -> new UserResponseDto(u.getId(), u.getEmail(), u.getName()))
                .map(mapper::toResponseDto)
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
*/

}
