package by.bsuir.manager.dao.factory;

import by.bsuir.manager.dao.UserDAO;
import by.bsuir.manager.dao.impl.SQLUserDAO;
import by.bsuir.manager.dao.impl.UserDAOImpl;

public final class DAOFactory {
    private static final DAOFactory INSTANCE = new DAOFactory();

    private final UserDAO sqlUserImpl = new UserDAOImpl();

    private DAOFactory() {}

    public static DAOFactory getInstance() {
        return INSTANCE;
    }

    public UserDAO getUserDAO() {
        return sqlUserImpl;
    }
}
