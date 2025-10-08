package de.aittr.user.service;

import de.aittr.user.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    List<UserResponseDto> getAllUsers();
    List<UserResponseDto> getAllUsersOrderedByName();
    List<UserResponseDto> getAllUsersOrderedByEmail();

}
