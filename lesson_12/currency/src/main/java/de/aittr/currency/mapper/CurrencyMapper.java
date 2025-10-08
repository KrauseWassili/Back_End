package de.aittr.currency.mapper;

import de.aittr.currency.dto.CurrencyResponseDto;
import de.aittr.currency.model.Currency;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CurrencyMapper {
    CurrencyResponseDto toDto(Currency currency);
    List<CurrencyResponseDto> toDto(List<Currency> currency);
}
