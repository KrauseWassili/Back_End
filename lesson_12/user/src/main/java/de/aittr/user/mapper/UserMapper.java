package de.aittr.user.mapper;

import de.aittr.user.dto.UserResponseDto;
import de.aittr.user.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponseDto toResponseDto(User user);
    List<UserResponseDto> toResponseDto(List<User> userList);
}
