package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        List<Auto> autos = new ArrayList<>();
        autos.add(new Auto("Toyota Avensis", 17_500, "red"));
        autos.add(new Auto("VW Passat 2.0", 12_700, "yellow"));
        autos.add(new Auto("Audi A6", 25_200, "black"));

        System.out.println(autos);

        ObjectMapper mapper = new ObjectMapper();

        mapper.writeValue(new File("autos.json"), autos);


    }
}