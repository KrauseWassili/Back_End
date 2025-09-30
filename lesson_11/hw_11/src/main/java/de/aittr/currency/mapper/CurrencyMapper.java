package de.aittr.currency.mapper;

import de.aittr.currency.dto.CurrencyRequestDto;
import de.aittr.currency.dto.CurrencyResponseDto;
import de.aittr.currency.model.Currency;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CurrencyMapper {

    CurrencyResponseDto toResponseDto(Currency currency);
    List<CurrencyResponseDto> toResponseDto(List<Currency> currencyList);

    CurrencyRequestDto fromRequestDto(Currency currency);
}
