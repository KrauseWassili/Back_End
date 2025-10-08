package de.aittr.currency.model;

import de.aittr.currency.dto.CurrencyResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class Conversion {
    private CurrencyResponseDto from;
    private CurrencyResponseDto to;
    private double amount;
    private double result;
    LocalDateTime timestamp;
    String msg;
}
