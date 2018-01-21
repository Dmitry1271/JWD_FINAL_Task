package by.tr.web.service.autorization;

import by.tr.web.dao.exception.UserDAOException;
import by.tr.web.entity.Token;
import by.tr.web.entity.User;
import by.tr.web.service.exception.ServiceException;
import by.tr.web.service.exception.UserServiceException;
import by.tr.web.service.exception.valid.InvalidUserInfoException;

import java.util.List;

/**
 * Created by cplus on 16.11.2017.
 */
public interface UserService {
    Token logination(String login, String password) throws UserServiceException;

    boolean successRegistration(List registerInfo) throws UserServiceException;

    User getUser(Integer userId) throws UserServiceException;

    void updateUser(Integer userId, List userInfo) throws InvalidUserInfoException, UserDAOException;

    boolean updatePassword(Integer userId, String oldPassword, String newPassword, String confirmPassword) throws UserServiceException;
}
