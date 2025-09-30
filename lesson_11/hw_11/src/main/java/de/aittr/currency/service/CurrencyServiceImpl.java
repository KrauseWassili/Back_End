package de.aittr.currency.service;

import de.aittr.currency.dto.CurrencyRequestDto;
import de.aittr.currency.dto.CurrencyResponseDto;
import de.aittr.currency.mapper.CurrencyMapper;
import de.aittr.currency.model.Currency;
import de.aittr.currency.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CurrencyServiceImpl implements CurrencyService {
private final CurrencyRepository repository;
private final CurrencyMapper mapper;


    @Override
    public List<CurrencyResponseDto> getAllCurrencies() {
        return mapper.toResponseDto(repository.findAll());
    }

    @Override
    public CurrencyResponseDto getCurrencyByCode(String code) {
        return mapper.toResponseDto(repository.findByCode(code));
    }

    @Override
    public double convert(String code1,String code2,double amount) {
        double rate1 = repository.findByCode(code1).getRate();
        double rate2 = repository.findByCode(code2).getRate();

        double usdAmount=0;
        if(rate1>0 && rate2>0 && amount>0) {
            usdAmount = amount / rate1 * rate2;
        }
        return usdAmount;
    }

    @Override
    public CurrencyResponseDto addCurrency(CurrencyRequestDto currencyRequestDto) {
        Currency currency = new Currency(currencyRequestDto.getCode(),currencyRequestDto.getName(),currencyRequestDto.getCountry(), currencyRequestDto.getRate());
        return mapper.toResponseDto(repository.add(currency));
    }
}
