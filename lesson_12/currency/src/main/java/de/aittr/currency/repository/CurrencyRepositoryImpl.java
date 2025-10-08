package de.aittr.currency.repository;

import de.aittr.currency.model.Currency;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CurrencyRepositoryImpl implements CurrencyRepository {

    private static final List<Currency> CURRENCIES = new ArrayList<>(List.of(
            new Currency("USD", "Доллар США","США", 1.0),
            new Currency("EUR", "Евро","Евросоюз", 0.95),
            new Currency("JPY", "Японская иена","Япония", 92.0),
            new Currency("RUB", "Рубль","РФ", 95)
    ));

    @Override
    public List<Currency> findAll() {
        return new ArrayList<>(CURRENCIES);
    }

    @Override
    public Currency findById(String code) {
        return findByCode(code);
    }

    @Override
    public Currency findByCode(String code) {
        return CURRENCIES.stream()
                .filter(c->c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(()->new RuntimeException(String.format("Currency with code (%s) not found",code)) );
    }


    @Override
    public Currency save(Currency currency) {
        String code = currency.getCode();
        try {
            Currency updatedCurrency = findByCode(code);  // изменение
            updatedCurrency.setCountry(currency.getCountry());
            updatedCurrency.setName(currency.getName());
            updatedCurrency.setRate(currency.getRate());
        } catch (Exception e){
            CURRENCIES.add(currency);   // создание новой записи
        }
      return currency;
    }
}
