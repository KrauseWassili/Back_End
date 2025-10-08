package de.aittr.user.service;

import de.aittr.user.dto.UserResponseDto;
import de.aittr.user.mapper.UserMapper;
import de.aittr.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;


    @Override
    public List<UserResponseDto> getAllUsers() {
        return mapper.toResponseDto(repository.findAll());
    }

    @Override
    public List<UserResponseDto> getAllUsersOrderedByName() {
        List<UserResponseDto> allUsers = getAllUsers();
        allUsers.sort((u1,u2)-> u1.getName().compareTo(u2.getName()));
        return allUsers;
    }

    @Override
    public List<UserResponseDto> getAllUsersOrderedByEmail() {
        List<UserResponseDto> allUsers = getAllUsers();
        allUsers.sort((u1,u2)-> u1.getEmail().compareTo(u2.getEmail()));
        return allUsers;
    }
}
