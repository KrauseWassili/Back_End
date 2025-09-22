package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();


        List<Auto> autos = mapper.readValue(new File("autos.json"), new TypeReference<List<Auto>>(){});

        for(Auto auto:autos){
            System.out.println(auto);
        }

    }
}
