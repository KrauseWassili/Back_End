package de.aittr.currency.controllers;


import de.aittr.currency.model.Currency;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CurrencyController {

    private final static List<Currency> CURRENCIES = List.of(
            new Currency("USD", "Доллар США", "США", 1.0),
            new Currency("EUR", "Евро", "Евросоюз", 0.95),
            new Currency("JPY", "Японская йена", "Япония", 9.0),
            new Currency("RUB", "Рубль", "РФ", 95)
    );

    @GetMapping("/rates")
    public List<Currency> getRates() {
        return CURRENCIES;
    }

    @GetMapping("/rates/{code}")
    public Currency getCurrency(@PathVariable String code) {
        return CURRENCIES.stream()
                .filter(c->c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .get();
    }


}
