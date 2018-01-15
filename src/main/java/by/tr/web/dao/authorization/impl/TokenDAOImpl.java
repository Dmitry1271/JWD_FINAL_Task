package by.tr.web.dao.authorization.impl;

import by.tr.web.exception.IncorrectTokenException;
import by.tr.web.util.TokenHelper;
import by.tr.web.dao.authorization.TokenDAO;
import by.tr.web.dao.connect.DBConnector;
import by.tr.web.dao.constant.QueryConstants;
import by.tr.web.dao.exception.TokenDAOException;
import by.tr.web.entity.Token;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by cplus on 25.12.2017.
 */
public class TokenDAOImpl implements TokenDAO {

    @Override
    public boolean refreshTokenIsRight(String refreshToken) throws TokenDAOException {
        return tokenIsRight(refreshToken, QueryConstants.SQL_SELECT_REFRESH_TOKEN_BY_VALUE_AND_TIME);
    }

    @Override
    public boolean accessTokenIsRight(String accessToken) throws TokenDAOException {
        return tokenIsRight(accessToken, QueryConstants.SQL_SELECT_ACCESS_TOKEN_BY_VALUE_AND_TIME);
    }

    @Override
    public Token renovateToken(Token token) throws TokenDAOException {
        try {
            return TokenHelper.updateToken(TokenHelper.parseId(token), TokenHelper.parseRole(token));
        } catch (SQLException | ClassNotFoundException | IncorrectTokenException e) {
            throw new TokenDAOException("Renovation token error", e);
        }
    }

    private boolean tokenIsRight(String tokenValue, String query) throws TokenDAOException {
        try (Connection connection = DBConnector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, tokenValue);
            ResultSet result = statement.executeQuery();
            return result.next();
        } catch (SQLException | ClassNotFoundException e) {
            throw new TokenDAOException("Check token error", e);
        }
    }
}
