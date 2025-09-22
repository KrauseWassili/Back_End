package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Person p1 = new Person("Jack", 23);
        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(p1);
        System.out.println(jsonString);

        List<Person> list = new ArrayList<>();
        list.add(new Person("John", 13));
        list.add(new Person("Ann", 17));

        mapper.writeValue(new File("persons.json"), list);

    }
}