package by.tr.web.dao.authorization.impl;

import by.tr.web.dao.authorization.UserDAO;
import by.tr.web.dao.connect.DBConnector;
import by.tr.web.dao.constant.DBFieldName;
import by.tr.web.dao.constant.QueryConstants;
import by.tr.web.dao.exception.UserDAOException;
import by.tr.web.dao.util.Cryptographer;
import by.tr.web.entity.Role;
import by.tr.web.entity.Token;
import by.tr.web.entity.User;
import by.tr.web.util.TokenHelper;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by cplus on 16.11.2017.
 */
public class UserDAOImpl implements UserDAO {
    private static final int REGISTER_LOGIN = 0;
    private static final int REGISTER_EMAIL = 1;
    private static final int REGISTER_PASSWORD = 2;
    private static final int REGISTER_PHONE_NUMBER = 4;
    private static final int REGISTER_ADDRESS = 5;

    private static final int USER_INFO_EMAIL = 0;
    private static final int USER_INFO_PHONE_NUMBER = 1;
    private static final int USER_INFO_ADDRESS = 2;

    private static final boolean IS_BANNED = false;
    private static final boolean IS_ADMIN = false;

    @Override
    public Token logination(String login, String password) throws UserDAOException {
        try (Connection connection = DBConnector.getConnection()) {
            int id;
            String salt;
            Role role;

            PreparedStatement statement = connection.prepareStatement(QueryConstants.SQL_SELECT_ALL_USER_BY_LOGIN);
            statement.setString(1, login);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                id = resultSet.getInt(DBFieldName.USER_ID);
                salt = resultSet.getString(DBFieldName.SALT);
                role = resultSet.getBoolean(DBFieldName.IS_ADMIN) ? Role.ADMIN : Role.CLIENT;

                if (resultSet.getString(DBFieldName.PASSWORD).equals(Cryptographer.getEncryptPassword(password, salt))) {
                    return TokenHelper.updateToken(id, role);
                }

            }

        } catch (SQLException | ClassNotFoundException | NoSuchAlgorithmException e) {
            throw new UserDAOException("Error in logination: " + e);
        }
        return null;
    }

    @Override
    public boolean existsLogin(String login) throws UserDAOException {
        try (Connection connection = DBConnector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(QueryConstants.SQL_SELECT_ALL_USER_BY_LOGIN);
            statement.setString(1, login);
            ResultSet result = statement.executeQuery();
            return result.next();

        } catch (SQLException | ClassNotFoundException e) {
            throw new UserDAOException("Error in finding user login: " + e);
        }
    }

    @Override
    public boolean successRegistration(List registerInfo) throws UserDAOException {
        try (Connection connection = DBConnector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(QueryConstants.SQL_INSERT_USER);
            statement.setString(1, (String) registerInfo.get(REGISTER_LOGIN));

            String salt = Cryptographer.generateSalt();
            String password = Cryptographer.getEncryptPassword((String) registerInfo.get(REGISTER_PASSWORD), salt);

            statement.setString(2, password);
            statement.setString(3, salt);
            statement.setString(4, (String) registerInfo.get(REGISTER_EMAIL));
            statement.setBoolean(5, IS_BANNED);
            statement.setBoolean(6, IS_ADMIN);
            statement.setString(7, (String) registerInfo.get(REGISTER_PHONE_NUMBER));
            statement.setString(8, (String) registerInfo.get(REGISTER_ADDRESS));

            return statement.executeUpdate() != 0;

        } catch (SQLException | NoSuchAlgorithmException | ClassNotFoundException e) {
            throw new UserDAOException("Error in Registration: " + e);
        }
    }

    @Override
    public User getUser(long userId) throws UserDAOException {
        try (Connection connection = DBConnector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(QueryConstants.SQL_SELECT_USER_BY_ID);
            statement.setLong(1, userId);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            User user = new User();
            user.setId(resultSet.getLong(DBFieldName.USER_ID));
            user.setLogin(resultSet.getString(DBFieldName.LOGIN));
            user.setEmail(resultSet.getString(DBFieldName.EMAIL));
            user.setAddress(resultSet.getString(DBFieldName.ADDRESS));
            user.setPhoneNumber(resultSet.getString(DBFieldName.PHONE_NUMBER));
            return user;
        } catch (SQLException | ClassNotFoundException e) {
            throw new UserDAOException("Error in getting user: " + e);
        }
    }

    @Override
    public void updateUser(long userId, List userInfo) throws UserDAOException {
        try (Connection connection = DBConnector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(QueryConstants.SQL_UPDATE_USER);
            statement.setString(1, (String) userInfo.get(USER_INFO_EMAIL));
            statement.setString(2, (String) userInfo.get(USER_INFO_PHONE_NUMBER));
            statement.setString(3, (String) userInfo.get(USER_INFO_ADDRESS));
            statement.setLong(4, userId);
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new UserDAOException("Error in updating user: " + e);
        }
    }

    @Override
    public boolean matchPassword(long userId, String password) throws UserDAOException {
        try (Connection connection = DBConnector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(QueryConstants.SQL_SELECT_USER_BY_ID);
            statement.setLong(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String salt = resultSet.getString(DBFieldName.SALT);
                return resultSet.getString(DBFieldName.PASSWORD).equals(Cryptographer.getEncryptPassword(password, salt));
            } else {
                return false;
            }
        } catch (SQLException | ClassNotFoundException | NoSuchAlgorithmException e) {
            throw new UserDAOException("Error in matching passwords: " + e);
        }
    }

    @Override
    public void updatePassword(long userId, String newPassword) throws UserDAOException {
        try (Connection connection = DBConnector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(QueryConstants.SQL_UPDATE_PASSWORD);
            String salt = Cryptographer.generateSalt();
            statement.setString(1, Cryptographer.getEncryptPassword(newPassword, salt));
            statement.setString(2, salt);
            statement.setLong(3, userId);
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException | NoSuchAlgorithmException e) {
            throw new UserDAOException("Error in updating password: " + e);
        }
    }
}
