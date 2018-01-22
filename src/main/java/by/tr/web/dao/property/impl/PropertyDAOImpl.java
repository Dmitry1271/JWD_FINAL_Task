package by.tr.web.dao.property.impl;

import by.tr.web.dao.connect.DBConnector;
import by.tr.web.dao.constant.QueryConstants;
import by.tr.web.dao.exception.PropertyDAOException;
import by.tr.web.dao.property.PropertyDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by cplus on 14.01.2018.
 */
public class PropertyDAOImpl implements PropertyDAO {
    @Override
    public void addProperties(int applianceId, Map<String, Object> properties) throws PropertyDAOException {
        try (Connection connection = DBConnector.getConnection()) {
            connection.setAutoCommit(false);
            CallableStatement statement = connection.prepareCall(QueryConstants.SQL_CALL_ADD_PROPERTIES);
            statement.setInt(1, applianceId);
            for (String propertyName : properties.keySet()) {
                statement.setString(2, propertyName);
                statement.setString(3, (String) properties.get(propertyName));
                statement.executeUpdate();
            }
            connection.commit();
        } catch (SQLException | ClassNotFoundException e) {
            throw new PropertyDAOException("Error in adding properties: " + e);
        }
    }
}
