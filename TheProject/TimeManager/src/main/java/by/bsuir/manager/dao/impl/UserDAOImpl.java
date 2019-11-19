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
    private static final String SQL_SELECT_ALL_USERS = "SELECT id, login FROM users";
    private static final String SQL_ADD_A_USER = "INSERT INTO users(id, login, password, time) VALUES(?, ?, ?, ?)";
    private static final String SQL_SELECT_USER_BY_LOGIN = "SELECT login FROM users WHERE id=?";

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

        System.out.println("getDBConnection: " + connection);
        return connection;
    }

    @Override
    public boolean signUp(User user) {
        boolean isCorrect = false;

        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("FOUND");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = getDBConnection();
        System.out.println("signUp DAO" + connection);
//        if(connection == null) {
//            //log
//            return isCorrect;
//        }

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
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/time_manager_db",
                    "postgres", "09102014Qm");
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_USERS);
            while(resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setTime(resultSet.getString("current_time"));
                users.add(user);
            }
        } catch (SQLException e) {
            /*e.printStackTrace();*/
            //throw new DAOException(e);
        } finally {
            close(statement);
            close(connection);
        }
        return users;
    }

    @Override
    public List<User> findUserByLogin(String patternName) throws DAOException {
        List<User> users = new ArrayList<>();
        System.out.println("findUserByLogin DAO: BEFORE");
        Connection connection = getDBConnection();
        System.out.println("findUserByLogin DAO" + connection);
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(SQL_SELECT_USER_BY_LOGIN); //exc
            statement.setString(1, patternName);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setTime(resultSet.getString("time"));
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
    public User findEntityById(Long id) {
        return null;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public boolean create(User user) {
        return false;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void close(Statement statement) {

    }

    @Override
    public void close(Connection connection) {

    }

    @Override
    public boolean signIn(String login, String password) {
        return false;
    }

    private String getCurrentTimeStamp() {
        return LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
    }
}
