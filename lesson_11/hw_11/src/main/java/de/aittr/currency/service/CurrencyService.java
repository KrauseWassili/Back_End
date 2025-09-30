package de.aittr.currency.service;

import de.aittr.currency.dto.CurrencyRequestDto;
import de.aittr.currency.dto.CurrencyResponseDto;
import de.aittr.currency.model.Currency;

import java.util.List;

public interface CurrencyService {

    List<CurrencyResponseDto> getAllCurrencies();
    CurrencyResponseDto getCurrencyByCode(String code);
    double convert(String code1,String code2,double amount);

    CurrencyResponseDto addCurrency(CurrencyRequestDto currency);


}
