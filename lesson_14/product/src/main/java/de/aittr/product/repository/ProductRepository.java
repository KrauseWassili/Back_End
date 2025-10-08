package de.aittr.product.repository;

import de.aittr.product.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAll();
    List<Product> findByActive(boolean active);
    Optional<Product> findById(Long id);
    Product save(Product product);

}
