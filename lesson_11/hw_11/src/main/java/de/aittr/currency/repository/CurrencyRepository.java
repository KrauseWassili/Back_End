package de.aittr.currency.repository;

import de.aittr.currency.model.Currency;

import java.util.List;

public interface CurrencyRepository {

    public List<Currency> findAll();
    public Currency findByCode(String currencyCode);
    public double findRate(String currencyCode);
    public Currency add(Currency currency);

}
