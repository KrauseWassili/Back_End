package de.aittr.jdbc_demo;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        UserRepository repository = new UserRepository();
        List<User> users = repository.findAll();
        users.forEach(System.out::println);

        System.out.println(repository.findById(1L));

        System.out.println("-----------------------");

        int res = repository.addUser("Mike", ",mike777@gmail.com", "qwert777");
        users = repository.findAll();
        users.forEach(System.out::println);
    }
}