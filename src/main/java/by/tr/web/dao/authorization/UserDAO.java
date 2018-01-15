package by.tr.web.dao.authorization;

import by.tr.web.dao.exception.DAOException;
import by.tr.web.dao.exception.UserDAOException;
import by.tr.web.entity.Token;
import by.tr.web.entity.User;

import java.util.List;

/**
 * Created by cplus on 16.11.2017.
 */
public interface UserDAO {

    Token logination(String login, String password) throws UserDAOException;
    boolean existsLogin(String login) throws UserDAOException;

    boolean successRegistration(List registerInfo) throws UserDAOException;
}
