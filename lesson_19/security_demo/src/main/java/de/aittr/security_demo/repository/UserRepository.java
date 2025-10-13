package de.aittr.security_demo.repository;

import de.aittr.security_demo.model.Role;
import de.aittr.security_demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface UserRepository extends JpaRepository<User, Long> {
    //public User save(User user);
    public Stream<User> findByName(String name);
    public Optional<User> findByEmail(String email);
    public List<User> findByRolesContaining(Role role);
}
