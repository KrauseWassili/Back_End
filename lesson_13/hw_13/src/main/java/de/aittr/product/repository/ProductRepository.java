package de.aittr.product.repository;

import de.aittr.product.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository {

    public List<Product> findAll();

    public Product findById(Long id);

    public int add(String title, BigDecimal price, boolean active);

    public int setActiveById(long id, boolean active);
}
