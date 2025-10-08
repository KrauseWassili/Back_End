package de.aittr.product.repository;

import de.aittr.product.model.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // тип сущности  , тип ID

    List<Product> findAll();
    List<Product> findAllByActive(boolean active);
    Product findById(long id);
    List<Product> findAll(Sort by);
    Product save(Product product);

}
