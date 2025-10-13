package de.aittr.security_demo.service;

import de.aittr.security_demo.dto.UserRequestDto;
import de.aittr.security_demo.dto.UserResponseDto;
import de.aittr.security_demo.model.User;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(UserRequestDto dto);
    List<UserResponseDto> getAllUsers();
    UserResponseDto getUserById(Long id);
    List<UserResponseDto> getAllUsersByRole(String role);
    UserResponseDto assignRole(Long userId, String role);
    UserResponseDto removeRole(Long userId, String role);

}
