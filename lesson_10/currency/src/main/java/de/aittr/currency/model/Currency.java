package de.aittr.currency.model;

public class Currency {
    private String code;
    private  String name;
    private String country;
    private double rate; // курс к USD

    public Currency(String code, String name, String country, double rate) {
        this.code = code;
        this.name = name;
        this.country = country;
        this.rate = rate;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public double getRate() {
        return rate;
    }
}
