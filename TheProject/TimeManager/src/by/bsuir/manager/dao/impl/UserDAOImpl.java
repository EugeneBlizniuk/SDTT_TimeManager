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
    private static final String SQL_SELECT_ALL_USERS = "SELECT id, login FROM userBook";
    private static final String SQL_ADD_A_USER = "INSERT INTO users(id, login, password, current_time) VALUES(?, ?, ?, ?)";
    private static final String SQL_SELECT_USER_BY_LOGIN = "SELECT login FROM userBook WHERE id=?";

    {
        try {
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Connection getDBConnection() {
        Connection connection = null;
        String url = "jdbc:postgresql://localhost:5432/java_ee_db";
        Properties properties = new Properties();

        properties.put("user", "postgres");
        properties.put("password", "09102014Qm");
        properties.put("autoReconnect", "true");
        properties.put("characterEncoding", "UTF-8");
        properties.put("useUnicode", "true");
        properties.put("useSSL", "true");

        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/users_db",
                    "postgres", "09102014Qm");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    @Override
    public boolean signUp(User user) {
        boolean isCorrect = false;
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
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/java_ee_db",
                    "postgres", "09102014Qm");
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_USERS);
            while(resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
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
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/java_ee_db",
                    "postgres", "09102014Qm");
            statement = connection.prepareStatement(SQL_SELECT_USER_BY_LOGIN);
            statement.setString(1, patternName);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
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
