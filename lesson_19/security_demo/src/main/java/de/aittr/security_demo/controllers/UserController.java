package de.aittr.security_demo.controllers;


import de.aittr.security_demo.dto.UserRequestDto;
import de.aittr.security_demo.dto.UserResponseDto;
import de.aittr.security_demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    @PostMapping
    public ResponseEntity<UserResponseDto> addUser(@RequestBody UserRequestDto userDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createUser(userDto));
    }

    @GetMapping
    // /users  - все пользователи
    // /users?role=admin  - все пользователи с заданной ролью
    public List<UserResponseDto> getUsers(@RequestParam(required = false) String role){
        if(role==null || role.isBlank()){
            return  service.getAllUsers();
        } else {
            return service.getAllUsersByRole(role);
        }

    }






}
