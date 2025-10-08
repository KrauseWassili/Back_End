package de.aittr.currency.service;

import de.aittr.currency.dto.CurrencyResponseDto;
import de.aittr.currency.model.Currency;

import java.util.List;

public interface CurrencyService {
    List<CurrencyResponseDto> findAll();
    CurrencyResponseDto findByCode(String code);
    CurrencyResponseDto createNewCurrency(Currency currency);
}
