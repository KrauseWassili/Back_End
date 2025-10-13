package de.aittr.security_demo.service;

import de.aittr.security_demo.dto.UserRequestDto;
import de.aittr.security_demo.dto.UserResponseDto;
import de.aittr.security_demo.exception.RoleNotFound;
import de.aittr.security_demo.exception.UserNotFoundException;
import de.aittr.security_demo.mapper.UserMapper;
import de.aittr.security_demo.model.Role;
import de.aittr.security_demo.model.User;
import de.aittr.security_demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.RoleNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private  final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public UserResponseDto createUser(UserRequestDto dto) {
        User user = mapper.fromDto(dto);
        user.addRole(Role.USER); // все пользователи по умолчанию имеют роль USER
        User saved = repository.save(user);
        return mapper.toDto(saved);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id))
        );
    }

    private static Optional<Role> roleOf(String role){
        try {
            return Optional.of(Role.valueOf(role.toUpperCase()));
        } catch (IllegalArgumentException e){
            return Optional.empty();
        }
    }

    @Override
    public List<UserResponseDto> getAllUsersByRole(String roleStr) {
        Role role = roleOf(roleStr).orElseThrow(() -> new RoleNotFound(roleStr));
        return mapper.toDto(repository.findByRolesContaining(role));
    }

    @Override
    @Transactional
    public UserResponseDto assignRole(Long userId, String roleStr) {
        Role role = roleOf(roleStr).orElseThrow(() -> new RoleNotFound(roleStr));
        User user = repository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        user.addRole(role);
        return mapper.toDto(user);

    }

    @Override
    public UserResponseDto removeRole(Long userId, String roleStr) {
        Role role = roleOf(roleStr).orElseThrow(() -> new RoleNotFound(roleStr));
        User user = repository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        user.removeRole(role);
        return mapper.toDto(user);
    }
}
