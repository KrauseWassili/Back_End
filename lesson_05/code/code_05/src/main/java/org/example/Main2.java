package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main2 {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(new File("p1.json"), Person.class);
        System.out.println(person);

        List<Person> list = mapper.readValue(new File("persons.json"), List<Person>.class);

        System.out.println(list);

        //СОздать новый мавен проект
        //Подключить эту библиотеку
        //Как загрузить json в лист.

    }

}
