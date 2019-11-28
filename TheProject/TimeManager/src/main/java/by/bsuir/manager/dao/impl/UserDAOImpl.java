package by.bsuir.manager.dao.impl;

import by.bsuir.manager.dao.UserDAO;
import by.bsuir.manager.dao.exception.DAOException;
import by.bsuir.manager.entity.User;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class UserDAOImpl implements UserDAO {
    private static final String SQL_SELECT_PASSWORD_BY_LOGIN = "SELECT password FROM users WHERE login=?";
    private static final String SQL_ADD_A_USER = "INSERT INTO users(id, login, password, registration_time) " +
                                                 "VALUES(?, ?, ?, ?)";
    private static final String SQL_SELECT_USER_BY_LOGIN = "SELECT 2 FROM users WHERE login=?";

    public UserDAOImpl() {
        try {
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection getDBConnection() {
        Connection connection = null;
        String url = "jdbc:postgresql://localhost:5432/time_manager_db";
        Properties properties = new Properties();

        properties.put("user", "postgres");
        properties.put("password", "09102014Qm");
        properties.put("autoReconnect", "true");
        properties.put("characterEncoding", "UTF-8");
        properties.put("useUnicode", "true");
        properties.put("useSSL", "true");

        try {
            connection = DriverManager.getConnection(url, properties);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    @Override
    public boolean signUp(User user) {
        boolean isCorrect = false;
        System.out.println("DAO sign up");
        Connection connection = getDBConnection();

        if(connection == null) {
            //log
            return isCorrect;
        }

        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(SQL_ADD_A_USER);

            statement.setInt(1, user.getId());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            statement.setString(4, getCurrentTimeStamp());
            statement.executeUpdate();

            isCorrect = true;
        } catch (SQLException e) {
            //log
            e.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }

        return isCorrect;
    }

    @Override
    public List<User> findUserByLogin(String patternName) throws DAOException {
        List<User> users = new ArrayList<>();
        Connection connection = getDBConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(SQL_SELECT_USER_BY_LOGIN);
            statement.setString(1, patternName);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setLogin(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setTime(resultSet.getString(4));
                users.add(user);
            }
        } catch (SQLException e) {
            /*e.printStackTrace();*/
            throw new DAOException(e);
        } finally {
            close(statement);
            close(connection);
        }
        return users;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public boolean isExisting(String login) throws DAOException {
        boolean isExisting = false;

        try(Connection connection = getDBConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_USER_BY_LOGIN)) {
            statement.setString(1, login);
            try(ResultSet resultSet = statement.executeQuery()) {
                if(resultSet.next()) {
                    isExisting = true;
                }
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return  isExisting;
    }

    @Override
    public boolean signIn(String login, String password) throws DAOException {
        boolean isCorrect = false;

        try(Connection connection = getDBConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_PASSWORD_BY_LOGIN)) {
            statement.setString(1, login);
            try(ResultSet resultSet = statement.executeQuery()) {
                if(resultSet.getString("password").equals(password)) {
                    isCorrect = true;
                }
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return  isCorrect;
    }

    private String getCurrentTimeStamp() {
        return LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
    }
}
