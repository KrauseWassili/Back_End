package de.aittr.security_demo.exception;

public class RoleNotFound extends RuntimeException{
    public RoleNotFound(String role) {
        super("The Role '%s' not found".formatted(role));
    }
}
