package de.aittr.currency.repository;

import de.aittr.currency.model.Currency;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CurrencyRepositoryImpl implements CurrencyRepository{

    private static final List<Currency> CURRENCIES = new ArrayList<>(List.of(
            new Currency("USD", "Доллар США","США", 1.0),
            new Currency("EUR", "Евро","Евросоюз", 0.95),
            new Currency("JPY", "Японская иена","Япония", 92.0),
            new Currency("RUB", "Рубль","РФ", 95)
    ));


    @Override
    public List<Currency> findAll() {
        return CURRENCIES.stream()
                .toList();
    }

    @Override
    public Currency findByCode(String currencyCode) {

        Optional<Currency> currency = CURRENCIES.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(currencyCode))
                .findFirst();
        return currency.orElse(null);
    }

    @Override
    public Currency add(Currency currency) {
        CURRENCIES.add(currency);
        return currency; //Подтверждаем
    }
}
