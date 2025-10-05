package de.aittr.product.repository;


import de.aittr.product.model.Product;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private final String DB_URL = "jdbc:postgresql://localhost:5432/back68";
    private final String DB_PRODUCT = "postgres";
    private final String DB_PASSWORD = "qwerty007";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Ошибка загрузки драйвера postgreSQL");
        }
    }

    @Override
    public List<Product> findAll() {
        List<Product> result = new ArrayList<>();
        String sql = "SELECT id,title,price,active FROM products";
        try (
                //jdbc:postgresql://localhost:5432/back68?product=DB_PRODUCT&password=DB_PASSWORD
                Connection connection = DriverManager.getConnection(DB_URL, DB_PRODUCT, DB_PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String title = resultSet.getString("title");
                BigDecimal price = resultSet.getBigDecimal("price");
                boolean active = resultSet.getBoolean("active");
                Product product = new Product(id, title, price, active);
                result.add(product);
            }

        } catch (Exception e) {
            System.out.println("Ошибка SQL");
        }
        return result;
    }

    @Override
    public Product findById(Long id) {
        Product product = null;
        String sql = "SELECT * FROM products WHERE id = ?";
        try (
                Connection connection = DriverManager.getConnection(DB_URL, DB_PRODUCT, DB_PASSWORD);
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setLong(1, id);
            try (
                    ResultSet rs = statement.executeQuery();
            ) {
                if (rs.next()) {
                    String title = rs.getString("title");
                    BigDecimal price = rs.getBigDecimal("price");
                    boolean active = rs.getBoolean("active");
                    product = new Product(id, title, price, active);
                }
            }

        } catch (SQLException e) {
            System.out.println("error!");
        }
        return product;
    }

    @Override
    public int add(String title, BigDecimal price, boolean active) {
        String sql = "INSERT INTO products (title, price, active) VALUES (?,?,?);";
        try (
                Connection connection = DriverManager.getConnection(DB_URL, DB_PRODUCT, DB_PASSWORD);
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, title);
            statement.setBigDecimal(2, price);
            statement.setBoolean(3, active);

            return statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("insert error");
        }
        return -1;
    }

    @Override
    public int setActiveById(long productId, boolean active) {
        String sql = "UPDATE products SET active = ? WHERE id = ?;";
        try (
                Connection connection = DriverManager.getConnection(DB_URL, DB_PRODUCT, DB_PASSWORD);
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setBoolean(1, active);
            statement.setLong(2, productId);

            return statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("update error");
        }
        return -1;
    }

}
