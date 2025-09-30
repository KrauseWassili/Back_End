package de.aittr.user.repository;

import de.aittr.user.model.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
    List<User> findByName(String name);
    List<User> findByEmail(String email);
    User findById(long id);


}
