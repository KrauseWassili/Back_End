package de.aittr.currency.controllers;

import de.aittr.currency.dto.CurrencyResponseDto;
import de.aittr.currency.model.Currency;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CurrencyController {

    private static final List<Currency> CURRENCIES = new ArrayList<>(List.of(
            new Currency("USD", "Доллар США","США", 1.0),
            new Currency("EUR", "Евро","Евросоюз", 0.95),
            new Currency("JPY", "Японская иена","Япония", 92.0),
            new Currency("RUB", "Рубль","РФ", 95)
    ));

    @GetMapping("/rates")
    public List<CurrencyResponseDto> getRates(){
        return CURRENCIES.stream()
                .map(c->new CurrencyResponseDto(c.getCode(), c.getRate()))
                .toList();
    }


    @GetMapping("/rates/{code}")
    public Currency getCurrency (@PathVariable(name = "code") String currencyCode ){

        return CURRENCIES.stream()
                .filter(c->c.getCode().equalsIgnoreCase(currencyCode))
                .findFirst()
                .get();

    }

    // myHost.de:8081/convertor?from=usd&to=jpy&amount=1000
    @GetMapping("/convertor")
    public double convert(
            @RequestParam(defaultValue = "usd") String from,
            @RequestParam (defaultValue = "rub") String to,
            @RequestParam (required = true) double amount
    ){


        Currency currencyFrom = CURRENCIES.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(from))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Не найдена валют: " + from));

        Currency currencyTo = CURRENCIES.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(to))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Не найдена валют: " + to));

        double usdAmount = amount / currencyFrom.getRate();
        return usdAmount * currencyTo.getRate();

    }

    @PostMapping("/rates")
    public Currency addCurrency(@RequestBody Currency currency){
        CURRENCIES.add(currency);
        return currency;
    }





}
