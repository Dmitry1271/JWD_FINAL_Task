package by.tr.web.dao.appliance.impl;

import by.tr.web.dao.appliance.ApplianceDAO;
import by.tr.web.dao.connect.DBConnector;
import by.tr.web.dao.constant.DBFieldName;
import by.tr.web.dao.constant.QueryConstants;
import by.tr.web.dao.exception.ApplianceDAOException;
import by.tr.web.entity.appliance.Appliance;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
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

    @Override
    public List<Appliance> getTopAppliances(String language) throws ApplianceDAOException {
        try (Connection connection = DBConnector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(QueryConstants.SQL_CALL_GET_TOP_NINE_APPLIANCES);
            statement.setString(1, language);

            ResultSet resultSet = statement.executeQuery();
            List<Appliance> appliances = new ArrayList<>();
            while (resultSet.next()) {
                Appliance appliance = new Appliance();
                appliance.setId(resultSet.getLong(DBFieldName.APPLIANCE_ID));
                appliance.setPrice(resultSet.getBigDecimal(DBFieldName.PRICE));
                appliance.setModel(resultSet.getString(DBFieldName.MODEL));
                appliance.setNumberAvailable(resultSet.getInt(DBFieldName.NUMBER_AVAILABLE));
                appliance.setImagePath(resultSet.getString(DBFieldName.IMAGE));
                appliance.setDiscount(resultSet.getBigDecimal(DBFieldName.DISCOUNT));
                appliance.setType(resultSet.getString(DBFieldName.TYPE_NAME));
                appliance.setRating(resultSet.getDouble(DBFieldName.RATING));
                appliances.add(appliance);
            }
            return appliances;
        } catch (SQLException | ClassNotFoundException e) {
            throw new ApplianceDAOException("Error in getting top appliances", e);
        }
    }
}
