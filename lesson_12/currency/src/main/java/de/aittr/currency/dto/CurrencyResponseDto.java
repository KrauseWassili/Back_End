package de.aittr.currency.dto;

import de.aittr.currency.model.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CurrencyResponseDto {
    private String code;
    private double rate; // курс к USD

    /*
    public  static CurrencyResponseDto toDto(Currency currency){
        return new CurrencyResponseDto(currency.getCode(), currency.getRate());
    }

     */
}
