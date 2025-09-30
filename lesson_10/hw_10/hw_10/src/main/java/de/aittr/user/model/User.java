package de.aittr.user.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private long id;
    private String email;
    private String name;
    private String password;

    public User(long id, String name, String email, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
    }
}
