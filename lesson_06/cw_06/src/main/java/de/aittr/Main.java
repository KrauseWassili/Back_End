package de.aittr;

import de.aittr.Model.Person;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Person person = new Person("Richard",45);

        Person person1 = Person.builder()
                .age(33)
                .name("Anna")
                .build();

        System.out.println(person);
        System.out.println(person1.getName());

        Person jack = Person.builder().name("Jack")
                .age(23)
                .nickname("Vovobei")
                .nickname("Kapitan")
                .build();

        System.out.println(jack);
    }
}