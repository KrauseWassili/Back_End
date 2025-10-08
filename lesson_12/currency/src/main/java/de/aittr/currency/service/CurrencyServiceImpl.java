package de.aittr.currency.service;

import de.aittr.currency.dto.CurrencyResponseDto;
import de.aittr.currency.mapper.CurrencyMapper;
import de.aittr.currency.model.Currency;
import de.aittr.currency.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CurrencyServiceImpl implements CurrencyService {
    private  final CurrencyRepository repository;
    private  final CurrencyMapper mapper;


    @Override
    public List<CurrencyResponseDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public CurrencyResponseDto findByCode(String code) {
        Currency currency = repository.findByCode(code);
        return mapper.toDto(currency);
    }

    @Override
    public CurrencyResponseDto createNewCurrency(Currency currency) {
        return mapper.toDto(repository.save(currency));
    }
}
