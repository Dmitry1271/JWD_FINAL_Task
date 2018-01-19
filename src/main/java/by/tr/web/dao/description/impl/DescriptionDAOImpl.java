package by.tr.web.dao.description.impl;

import by.tr.web.dao.connect.DBConnector;
import by.tr.web.dao.constant.QueryConstants;
import by.tr.web.dao.description.DescriptionDAO;
import by.tr.web.dao.exception.DescriptionDAOException;
import by.tr.web.entity.Language;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by cplus on 16.01.2018.
 */
public class DescriptionDAOImpl implements DescriptionDAO {
    @Override
    public void addDescription(Map<Language, String> descriptions, int applianceId) throws DescriptionDAOException {
        try (Connection connection = DBConnector.getConnection()) {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(QueryConstants.SQL_INSERT_DESCRIPTION);
            statement.setInt(1, applianceId);
            for (Language language : descriptions.keySet()) {
                statement.setString(2, language.getName());
                statement.setString(3, descriptions.get(language));
                statement.executeUpdate();
            }
            connection.commit();
        } catch (SQLException | ClassNotFoundException e) {
            throw new DescriptionDAOException("Error in adding description", e);
        }
    }

    @Override
    public void deleteDescription(int applianceId) throws DescriptionDAOException {
        try (Connection connection = DBConnector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(QueryConstants.SQL_DELETE_DESCRIPTION);
            statement.setInt(1, applianceId);
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new DescriptionDAOException("Error in deleting description", e);
        }
    }
}
