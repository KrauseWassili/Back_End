package de.aittr.security_demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ApiError {
    private final String msg;
    private final HttpStatus status;
    private LocalDateTime timestamp = LocalDateTime.now();
}
