package de.aittr.currency.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Currency {
    private String code;
    private  String name;
    private String country;
    private double rate; // курс к USD

}
