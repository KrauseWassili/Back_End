package de.aittr.jdbc_demo;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private final String DB_URL = "jdbc:postgresql://localhost:5432/back68";
    private final String DB_USER = "postgres";
    private final String DB_PASSWORD = "qwerty007";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Ошибка загрузки драйвера postgreSQL");
        }
    }

    public List<User> findAll() {
        List<User> result = new ArrayList<>();
        String sql = "SELECT id,name,email,password FROM t_user";
        try (
                //jdbc:postgresql://localhost:5432/back68?user=DB_USER&password=DB_PASSWORD
                Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                User user = new User(id, name, email, password);
                result.add(user);
            }

        } catch (Exception e) {
            System.out.println("Ошибка SQL");
        }
        return result;
    }


    public User findById(Long id){
        User user = null;
        String sql = "SELECT * FROM t_user WHERE id = ?";
        try(
                Connection connection = DriverManager.getConnection(DB_URL, DB_USER,DB_PASSWORD);
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setLong(1,id);
            try(
                    ResultSet rs = statement.executeQuery();
            ) {
                if(rs.next()){
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    user = new User(id,name,email,password);
                }
            }

        } catch (SQLException e ){
            System.out.println("errror!");
        }
        return user;
    }

    public int addUser(String name, String email, String password) {
        //String sql = "INSERT INTO t_user (name, email, password) VALUES ("mile","mile@mail.com","qwer");";
        String sql = "INSERT INTO t_user (name, email, password) VALUES (?,?,?);";
        try (
                Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password);

            return statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("insert error");
        }
        return -1;
    }

}
