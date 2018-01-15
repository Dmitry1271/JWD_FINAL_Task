package by.tr.web.service.autorization.impl;

import by.tr.web.dao.DAOFactory;
import by.tr.web.dao.authorization.UserDAO;
import by.tr.web.dao.exception.UserDAOException;
import by.tr.web.entity.Token;
import by.tr.web.service.autorization.UserService;
import by.tr.web.service.exception.UserServiceException;
import by.tr.web.service.valid.ValidatorDirector;
import by.tr.web.service.valid.ValidatorName;
import by.tr.web.service.valid.util.RegisterInfoValidator;

import java.util.List;

/**
 * Created by cplus on 16.11.2017.
 */
public class UserServiceImpl implements UserService {
    private static final int LOGIN = 0;

    @Override
    public Token logination(String login, String password) throws UserServiceException {
        ValidatorDirector validatorDirector = new ValidatorDirector();
        if (validatorDirector.takeValidator(ValidatorName.LOGIN).isValidData(login) &&
                validatorDirector.takeValidator(ValidatorName.PASSWORD).isValidData(password)) {

            DAOFactory instance = DAOFactory.getInstance();
            UserDAO userDAO = instance.getUserDAO();

            try {
                return userDAO.logination(login, password);
            } catch (UserDAOException e) {
                throw new UserServiceException(e);
            }
        } else {
            return null;
        }
    }

    @Override
    public boolean successRegistration(List registerInfo) throws UserServiceException {
        if (RegisterInfoValidator.isValidData(registerInfo)) {

            DAOFactory instance = DAOFactory.getInstance();
            UserDAO userDAO = instance.getUserDAO();

            try {
                return !userDAO.existsLogin((String) registerInfo.get(LOGIN)) && userDAO.successRegistration(registerInfo);
            } catch (UserDAOException e) {
                throw new UserServiceException(e);
            }
        }
        return false;
    }
}
