package de.aittr.currency.service;

import de.aittr.currency.dto.CurrencyResponseDto;
import de.aittr.currency.model.Conversion;
import de.aittr.currency.model.Currency;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@RequiredArgsConstructor
@Service
public class ConverterServiceImpl implements ConverterService{
    private final  CurrencyService currencyService;

    @Override
    public Conversion convert(String from, String to, double amount) {
        String msg="";
        CurrencyResponseDto currencyFrom = null;
        CurrencyResponseDto currencyTo = null;
        try {
            currencyFrom = currencyService.findByCode(from);
        } catch (Exception e){
            msg += e.getMessage();
        }
        try {
            currencyTo = currencyService.findByCode(to);
        } catch (Exception e){
            msg += e.getMessage();
        }


        if (currencyTo!=null && currencyFrom!=null) {
            double usdAmount = amount / currencyFrom.getRate();
            double res = usdAmount * currencyTo.getRate();
            return new Conversion(currencyFrom, currencyTo, amount, res, LocalDateTime.now(), "");
        } else {
            return new Conversion(currencyFrom, currencyTo, amount, 0, LocalDateTime.now(),msg);
        }
    }
}
