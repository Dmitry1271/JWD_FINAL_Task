package by.tr.web.dao.appliance.impl;

import by.tr.web.dao.appliance.ApplianceDAO;
import by.tr.web.dao.connect.DBConnector;
import by.tr.web.dao.constant.QueryConstants;
import by.tr.web.dao.exception.ApplianceDAOException;

import java.math.BigDecimal;
import java.sql.*;
import java.util.List;

/**
 * Created by cplus on 12.01.2018.
 */
public class ApplianceDAOImpl implements ApplianceDAO {
    private static final int PRICE = 0;
    private static final int MODEL = 1;
    private static final int NUMBER_AVAILABLE = 2;
    private static final int IMAGE = 3;
    private static final int DISCOUNT = 4;
    private static final String LAST_ID_APPLIANCE = "last_id_appliance";

    @Override
    public int addNewAppliance(List applianceInfo) throws ApplianceDAOException {
        try (Connection connection = DBConnector.getConnection()) {
            CallableStatement statement = connection.prepareCall(QueryConstants.SQL_CALL_ADD_NEW_APPLIANCE);
            statement.setBigDecimal(1, new BigDecimal((String) applianceInfo.get(PRICE)));
            statement.setString(2, (String) applianceInfo.get(MODEL));
            statement.setInt(3, Integer.parseInt((String) applianceInfo.get(NUMBER_AVAILABLE)));
            statement.setString(4, (String) applianceInfo.get(IMAGE));
            statement.setDouble(5, Double.parseDouble((String) applianceInfo.get(DISCOUNT)));

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt(LAST_ID_APPLIANCE);


        } catch (SQLException | ClassNotFoundException e) {
            throw new ApplianceDAOException("Error in adding appliance ", e);
        }
    }

    @Override
    public void deleteAppliance(int applianceId) throws ApplianceDAOException {
        try (Connection connection = DBConnector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(QueryConstants.SQL_DELETE_APPLIANCE);
            statement.setInt(1, applianceId);
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new ApplianceDAOException("Delete appliance error", e);
        }
    }
}
