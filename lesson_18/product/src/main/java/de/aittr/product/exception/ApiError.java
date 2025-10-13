package de.aittr.product.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class ApiError {
    private final String message;
    private final HttpStatus status;
    private LocalDateTime timestamp = LocalDateTime.now();
}
