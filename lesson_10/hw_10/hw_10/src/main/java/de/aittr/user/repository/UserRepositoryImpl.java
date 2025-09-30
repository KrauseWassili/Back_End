package de.aittr.user.repository;

import de.aittr.user.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository{

    private static Long lastId = 4L;

    private static final Map<Long, User> USERS = new HashMap<>();

    static {
        USERS.put(1L, new User(1L,"Peter", "a.peter@web.de", "12345"));
        USERS.put(2L, new User(2L,"Anna", "t.anna@web.de", "23456"));
        USERS.put(3L, new User(3L,"Stefan", "m.stefan@web.de", "34567"));
        USERS.put(4L, new User(4L,"Maria", "b.maria@web.de", "45678"));
    }

    @Override
    public List<User> findAll() {
        List<User> list = USERS.entrySet().stream()
                .map(Map.Entry::getValue)
                .toList();
        return new ArrayList<>(list);
    }

    @Override
    public List<User> findByName(String name) {
        return null;
    }

    @Override
    public List<User> findByEmail(String email) {
        return null;
    }

    @Override
    public User findById(long id) {
        return USERS.get(id);
    }
}
