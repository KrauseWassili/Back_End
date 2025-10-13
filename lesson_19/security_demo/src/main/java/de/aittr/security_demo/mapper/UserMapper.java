package de.aittr.security_demo.mapper;

import de.aittr.security_demo.dto.UserRequestDto;
import de.aittr.security_demo.dto.UserResponseDto;
import de.aittr.security_demo.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User fromDto(UserRequestDto dto);
    UserResponseDto toDto(User user);
    List<UserResponseDto> toDto(List<User> user);
}
