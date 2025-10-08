package de.aittr.currency.service;

import de.aittr.currency.model.Conversion;

public interface ConverterService {
    Conversion convert(String from, String to, double amount);
}
