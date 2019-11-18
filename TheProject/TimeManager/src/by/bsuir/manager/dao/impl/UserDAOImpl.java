package by.bsuir.manager.dao.impl;

import by.bsuir.manager.dao.UserDAO;
import by.bsuir.manager.dao.exception.DAOException;
import by.bsuir.manager.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private static final String SQL_SELECT_ALL_USERS = "SELECT id, login FROM userBook";
    private static final String SQL_ADD_A_USER = "INSERT INTO userTable (login, password) VALUES(?,?)";
    private static final String SQL_SELECT_USER_BY_LOGIN = "SELECT login FROM userBook WHERE id=?";

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

    @Override
    public boolean signUp(User user) {
        boolean isCorrect = false;

        return isCorrect;
    }
}
