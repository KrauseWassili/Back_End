package de.aittr.code.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private static int index=0;
    private int id;
    private String email;
    private String name;
    private String password;

    public User(String name, String email, String password) {
        this.id = ++index;
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
