package de.aittr.currency.repository;

import de.aittr.currency.model.Currency;
import java.util.List;

public interface CurrencyRepository {
    List<Currency> findAll();
    Currency findById(String code);
    Currency findByCode(String code);
    Currency save(Currency currency);
}
