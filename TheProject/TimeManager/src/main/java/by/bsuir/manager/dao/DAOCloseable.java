package by.bsuir.manager.dao;

import by.bsuir.manager.dao.exception.DAOException;
import by.bsuir.manager.entity.Entity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface DAOCloseable <K, T extends Entity> {
//    List<T> findAll();
//    T findEntityById(K id);
    boolean delete(T t);
//    boolean delete(K id);
//    boolean create(T t);
    boolean isExisting(K login) throws DAOException;
//    T update(T t);

    default void close(Statement statement) {
        try {
            if(statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            //log has to be here
            e.printStackTrace();
        }
    }

    default void close(Connection connection) {
        try {
            if(connection != null) {
                //return connection to the pool
                connection.close();
            }
        } catch (SQLException e) {
            //log has to be here
            e.printStackTrace();
        }
    }
}
