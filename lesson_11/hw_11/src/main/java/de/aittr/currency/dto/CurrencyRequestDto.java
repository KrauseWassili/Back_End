package de.aittr.currency.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CurrencyRequestDto {
    private String code;
    private  String name;
    private String country;
    private double rate;
}
