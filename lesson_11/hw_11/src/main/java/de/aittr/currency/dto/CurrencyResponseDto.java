package de.aittr.currency.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CurrencyResponseDto {
    private String code;
    private double rate; // курс к USD
}
