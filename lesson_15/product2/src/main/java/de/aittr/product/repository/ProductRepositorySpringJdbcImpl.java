package de.aittr.product.repository;

import de.aittr.product.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@ConditionalOnProperty(name = "app.repository.type", havingValue = "jdbc-spring")
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
        String sql = "SELECT * FROM product";
        return template.query(sql,rowMapper);
    }

    @Override
    public List<Product> findByActive(boolean active) {
        String sql = "SELECT * FROM product WHERE active= ?";
        return template.query(sql,rowMapper,active);
    }

    @Override
    public Optional<Product> findById(Long id) {
        String sql = "SELECT * FROM product WHERE id= ?";
        try {
            Product product = template.queryForObject(sql, rowMapper, id);
            return Optional.of(product);
        } catch (EmptyResultDataAccessException e){
            return Optional.empty();
        }


    }

    @Override
    public Product save(Product product) {
        if(product.getId()==null){
            Product newProduct = createNew(product);
            if (newProduct.getId()!= null) {
                return createNew(newProduct);
            }
        } else {
            int updated = update(product);
            if (updated>=1){
                return product;
            }
        }
        return null;
    }

    private int update(Product product){
        String sql = "UPDATE product SET title = ?, price = ?, active = ? WHERE id = ?;";
        return template.update(sql,
                product.getTitle(),product.getPrice(),product.isActive(), product.getId());
    }

    private Product createNew(Product product){
        String sql = "INSERT INTO product (title, price, active) VALUES (?,?,?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        PreparedStatementCreator preparedStatementCreator = connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, product.getTitle());
            ps.setBigDecimal(2, product.getPrice());
            ps.setBoolean(3, product.isActive());
            return ps;
        };
        template.update(preparedStatementCreator,keyHolder);
        Map<String, Object> keys = keyHolder.getKeys();
        if(keys!=null && keys.containsKey("id")){
            long id = ((Number) keys.get("id")).longValue();
            product.setId(id);
        }
        return product;


    }


}
