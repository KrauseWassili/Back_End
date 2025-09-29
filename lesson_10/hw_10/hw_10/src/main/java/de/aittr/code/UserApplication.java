/*
В проекте про User (дз урока #8) реализуйте следующее:

добавление пользователя (Post /user) при этом вы не должны вводить id - его должна проставлять система и возвращать user c уже готовым id
давайте добавим в user полe password. Естественно, при отображении пользователей система не должна показывать password (подсказка: dto)
реализуйте вывод списка пользователей в отсортированном виде:
users?sort=name - по имени
user?sort=email - по еmail
 */


package de.aittr.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

}
