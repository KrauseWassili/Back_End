package de.aittr.code.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private static int index=0;
    private int id;
    private String email;
    private String name;

    public User(String name, String email) {
        this.id = ++index;
        this.name = name;
        this.email = email;
    }
}
