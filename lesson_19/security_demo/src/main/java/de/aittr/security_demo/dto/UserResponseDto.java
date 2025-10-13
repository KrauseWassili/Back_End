package de.aittr.security_demo.dto;

import de.aittr.security_demo.model.Role;

import java.util.HashSet;
import java.util.Set;

public class UserResponseDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Set<Role> roles;
}
