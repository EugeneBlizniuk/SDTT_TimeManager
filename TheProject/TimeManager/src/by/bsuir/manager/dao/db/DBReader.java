package by.bsuir.manager.dao.db;

import by.bsuir.manager.entity.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class DBReader {
    public List<User> readDB(String url, Properties properties) {
        List<User> users = new LinkedList<>();
        try(Connection connection = DriverManager.getConnection(url, properties);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            String sql = "SELECT id, title, author, quantity from books";
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                String login = resultSet.getString(2);
                String password = resultSet.getString(3);

                users.add(new User(login, password));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
}
