package de.aittr.demo1.controllers.model;

public class Person {
    private String Name;
    private int age;

    public Person(String name, int age) {
        Name = name;
        this.age = age;
    }

    public String getName() {
        return Name;
    }

    public int getAge() {
        return age;
    }
}
