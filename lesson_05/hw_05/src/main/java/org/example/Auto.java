package org.example;

public class Auto {
    private static int counter=0;
    private int number;
    private String model;
    private double price;
    private String color;

    public Auto(String model, double price, String color) {
        this.model = model;
        this.price = price;
        this.color = color;
        this.number = ++counter;
    }

    public Auto() {
    }

    public int getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "number=" + number +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
