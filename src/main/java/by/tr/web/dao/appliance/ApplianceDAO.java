package by.tr.web.dao.appliance;

import by.tr.web.dao.exception.ApplianceDAOException;

import java.util.List;

/**
 * Created by cplus on 12.01.2018.
 */
public interface ApplianceDAO {
    int addNewAppliance(List applianceInfo) throws ApplianceDAOException;
    void deleteAppliance(int applianceId) throws ApplianceDAOException;
}
