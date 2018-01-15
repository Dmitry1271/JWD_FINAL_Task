package by.tr.web.dao.type.impl;

import by.tr.web.dao.type.TypeDAO;
import by.tr.web.dao.connect.DBConnector;
import by.tr.web.dao.constant.DBFieldName;
import by.tr.web.dao.constant.QueryConstants;
import by.tr.web.dao.exception.TypeDAOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cplus on 10.01.2018.
 */
public class TypeDAOImpl implements TypeDAO {
    @Override
    public List<String> getAllTypes(String language) throws TypeDAOException {
        try (Connection connection = DBConnector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(QueryConstants.SQL_SELECT_ALL_TYPES_BY_LANGUAGE);
            statement.setString(1, language);
            ResultSet resultSet = statement.executeQuery();
            List<String> types = new ArrayList<>();
            while (resultSet.next()) {
                types.add(resultSet.getString(DBFieldName.TYPE_NAME));
            }
            return types;
        } catch (SQLException | ClassNotFoundException e) {
            throw new TypeDAOException(e);
        }
    }

    @Override
    public int getTypeId(String typeName) throws TypeDAOException {
        try (Connection connection = DBConnector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(QueryConstants.SQL_SELECT_TYPE_ID_BY_NAME);
            statement.setString(1, typeName);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt(DBFieldName.TYPE_ID);
        } catch (SQLException | ClassNotFoundException e) {
            throw new TypeDAOException("Error in getting id", e);
        }
    }

    @Override
    public void addTypeToAppliance(List<Integer> listTypeId, int applianceId) throws TypeDAOException {
        try (Connection connection = DBConnector.getConnection()) {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(QueryConstants.SQL_INSERT_TYPE_ID_AND_APPLIANCE_ID);
            statement.setInt(2, applianceId);
            for (int typeId : listTypeId) {
                statement.setInt(1, typeId);
                statement.executeUpdate();
            }
            connection.commit();
        } catch (SQLException | ClassNotFoundException e) {
            throw new TypeDAOException("Error in adding type to appliance", e);
        }
    }

    @Override
    public void deleteTypeFromAppliance(int applianceId) throws TypeDAOException {
        try (Connection connection = DBConnector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(QueryConstants.SQL_DELETE_TYPE_FROM_APPLIANCE);
            statement.setInt(1, applianceId);
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new TypeDAOException("Error in deleting type from appliance", e);
        }
    }
}
