package de.aittr.security_demo.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("User ID%d not found".formatted(id) );
    }
}
