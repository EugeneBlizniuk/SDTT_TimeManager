package by.bsuir.manager.dao.db;

import by.bsuir.manager.entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DBWriter {
    public void writeToDB(String url, Properties properties, User user) {
        String sqlRequest = "INSERT INTO books(id, title, author, quantity) VALUES(?, ?, ?, ?)";

        try(Connection connection = DriverManager.getConnection(url, properties)) {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest);

            preparedStatement.setInt(1, user.hashCode());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
