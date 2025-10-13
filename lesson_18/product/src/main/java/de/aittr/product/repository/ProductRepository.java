package de.aittr.product.repository;

import de.aittr.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // тип сущности  , тип ID

    List<Product> findAll();
    List<Product> findAllByActive(boolean active);
    Optional<Product> findById(Long id);
    Product save(Product product);

}
