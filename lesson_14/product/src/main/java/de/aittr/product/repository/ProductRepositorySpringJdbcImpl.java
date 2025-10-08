

package de.aittr.product.repository;

import de.aittr.product.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Primary
@Repository
@RequiredArgsConstructor
public class ProductRepositorySpringJdbcImpl implements ProductRepository{

    private final JdbcTemplate template;

    private final RowMapper<Product> rowMapper = ((rs, rowNum) -> new Product(
            rs.getLong("id"),
            rs.getString("title"),
            rs.getBigDecimal("price"),
            rs.getBoolean("active")
    ));



    @Override
    public List<Product> findAll() {
        String sql = "SELECT * FROM products";
        return template.query(sql,rowMapper);
    }

    @Override
    public List<Product> findByActive(boolean active) {
        String sql = "SELECT * FROM products WHERE active= ?";
        return template.query(sql,rowMapper,active);
    }

    @Override
    public Optional<Product> findById(Long id) {
        String sql = "SELECT * FROM products WHERE id= ?";
        try {
            Product product = template.queryForObject(sql, rowMapper, id);
            return Optional.of(product);
        } catch (EmptyResultDataAccessException e){
            return Optional.empty();
        }


    }

    @Override
    public Product save(Product product) {
        return null;
    }
}
