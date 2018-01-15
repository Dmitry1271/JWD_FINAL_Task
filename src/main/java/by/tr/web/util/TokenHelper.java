package by.tr.web.util;

import by.tr.web.controller.constant.AttributeConstant;
import by.tr.web.dao.connect.DBConnector;
import by.tr.web.dao.constant.QueryConstants;
import by.tr.web.dao.util.Cryptographer;
import by.tr.web.entity.Role;
import by.tr.web.entity.Token;
import by.tr.web.exception.EmptyCookieException;
import by.tr.web.exception.IncorrectTokenException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by cplus on 29.12.2017.
 */
public final class TokenHelper {
    private static final String TOKEN_CONTENT_REGEX = "([0-9]+):(GUEST|CLIENT|ADMIN):(.{32})";
    private static final int GROUP_ID = 1;
    private static final int GROUP_ROLE = 2;
    private static final int ZERO = 0;

    private TokenHelper() {
    }


    public static Integer parseId(Token token) throws IncorrectTokenException {
        Pattern pattern = Pattern.compile(TOKEN_CONTENT_REGEX);
        Matcher matcher = pattern.matcher(token.getAccessToken());
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(GROUP_ID));
        } else {
            throw new IncorrectTokenException("Incorrect token id");
        }
    }

    public static Role parseRole(Token token) throws IncorrectTokenException {
        Pattern pattern = Pattern.compile(TOKEN_CONTENT_REGEX);
        Matcher matcher = pattern.matcher(token.getAccessToken());
        if (matcher.find()) {
            return Role.valueOf(matcher.group(GROUP_ROLE));
        } else {
            throw new IncorrectTokenException("Incorrect token Role");
        }
    }

    public static Token createTokenFromCookieData(Cookie[] cookies) throws EmptyCookieException {
        if (cookies != null) {
            Token token = new Token();
            for (Cookie cookie : cookies) {
                if (AttributeConstant.ACCESS_TOKEN.equals(cookie.getName())) {
                    token.setAccessToken(cookie.getValue());
                } else if (AttributeConstant.REFRESH_TOKEN.equals(cookie.getName())) {
                    token.setRefreshToken(cookie.getValue());
                }
            }
            return token;
        } else {
            throw new EmptyCookieException();
        }
    }

    public static void removeTokenFromCookie(Cookie[] cookies, HttpServletResponse response) throws EmptyCookieException {
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (AttributeConstant.REFRESH_TOKEN.equals(cookie.getName()) ||
                        AttributeConstant.ACCESS_TOKEN.equals(cookie.getName())) {
                    removeCookie(cookie, response);
                }
            }
        } else {
            throw new EmptyCookieException();
        }
    }

    public static Token updateToken(Integer id, Role role) throws SQLException, ClassNotFoundException {
        String accessToken = Cryptographer.generateAccessToken(id, role);
        String refreshToken = Cryptographer.generateRefreshToken();
        Connection connection = DBConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(QueryConstants.SQL_UPDATE_TOKEN);
        statement.setString(1, accessToken);
        statement.setString(2, refreshToken);
        statement.setInt(3, id);
        statement.executeUpdate();

        return new Token(accessToken, refreshToken);
    }

    private static void removeCookie(Cookie cookie, HttpServletResponse response) {
        cookie.setValue(null);
        cookie.setMaxAge(ZERO);
        response.addCookie(cookie);
    }

}
