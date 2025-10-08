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
    /*
    private static final Map<Long, User> USERS = Map.of(
            1L,new User(1L, "Nick", "nick@mail.com"),
            2L,new User(2L, "Jack", "jack@mail.com"),
            3L,new User(3L, "Jeff", "jeff@mail.com")
    );

     */



    private static final Map<Long, User> USERS = new HashMap<>();
    static {
        System.out.println("Инициализируем map, имитация Базы данных");
        USERS.put(1L,new User(1L, "Nick", "nick@mail.com","qwe1"));
        USERS.put(2L,new User(2L, "Jack", "jack@mail.com","qwe2"));
        USERS.put(3L,new User(3L, "Ann", "ann@mail.com","qwe3"));
        USERS.put(4L,new User(4L, "Lena", "lena@mail.com", "qwe4"));
        System.out.println(USERS);
    }

    @Override
    public List<User> findAll() {
        List<User> list = USERS.entrySet()
                .stream()
                .map(e -> e.getValue())
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
    public User findById(Long id) {
        return USERS.get(id);
    }
}
