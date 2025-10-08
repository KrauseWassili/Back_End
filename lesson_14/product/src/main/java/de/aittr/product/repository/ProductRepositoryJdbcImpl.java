package de.aittr.product.repository;

import de.aittr.product.exception.ProductNotFoundException;
import de.aittr.product.exception.ProductRepositoryException;
import de.aittr.product.model.Product;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryJdbcImpl implements ProductRepository {
    private final String DB_URL = "jdbc:postgresql://localhost:5432/back68";
    private final String DB_PRODUCT = "postgres";
    private final String DB_PASSWORD = "qwerty007";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new ProductRepositoryException("Ошибка загрузки драйвера postgreSQL");
        }
    }



    @Override
    public List<Product> findAll() {
        String sql = "SELECT * FROM products";
        List<Product> list = new ArrayList<>();

        try(
                Connection connection = DriverManager.getConnection(DB_URL,DB_PRODUCT,DB_PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                ){
          while (resultSet.next()){
              long id = resultSet.getLong("id");
              String title = resultSet.getString("title");
              BigDecimal price = resultSet.getBigDecimal("price");
              boolean active = resultSet.getBoolean("active");
              list.add(new Product(id,title,price,active));
          }

        } catch (SQLException e){
            throw new ProductRepositoryException("Product Repository error: findAll() ");
        }
        return list;
    }

    @Override
    public List<Product> findByActive(boolean active) {
        String sql = "SELECT * FROM products WHERE products.active = ?";
        List<Product> list = new ArrayList<>();
        try(
                Connection connection = DriverManager.getConnection(DB_URL,DB_PRODUCT,DB_PASSWORD);
                PreparedStatement statement = connection.prepareStatement(sql);
                ) {
            statement.setBoolean(1, active);
            try(ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()){
                    long id = resultSet.getLong("id");
                    String title = resultSet.getString("title");
                    BigDecimal price = resultSet.getBigDecimal("price");
                    list.add(new Product(id,title,price,active));
                }
            }

        } catch (SQLException e){
            throw new ProductRepositoryException("Product Repository error: findByActive()");
        }



        return list;
    }

    @Override
    public Optional<Product> findById(Long id) {
        String sql = "SELECT * FROM products WHERE products.id = ?";
        try(
                Connection connection = DriverManager.getConnection(DB_URL,DB_PRODUCT,DB_PASSWORD);
                PreparedStatement statement = connection.prepareStatement(sql);
                ) {
            statement.setLong(1,id);
            try(ResultSet resultSet = statement.executeQuery()) {
                if(resultSet.next()){
                    String title = resultSet.getString("title");
                    BigDecimal price = resultSet.getBigDecimal("price");
                    boolean active = resultSet.getBoolean("active");
                    return Optional.of(new Product(id,title,price,active));
                }
            }

        } catch (SQLException e){
            throw new ProductNotFoundException(id);
        }
        return Optional.empty();

    }


    @Override
    public Product save(Product product) {
        return null;
    }
}
