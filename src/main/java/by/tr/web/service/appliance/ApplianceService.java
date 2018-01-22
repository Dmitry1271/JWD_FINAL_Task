package by.tr.web.service.appliance;

import by.tr.web.entity.appliance.Appliance;
import by.tr.web.service.exception.ApplianceServiceException;
import by.tr.web.service.exception.valid.InvalidApplianceException;

import java.util.List;

/**
 * Created by cplus on 12.01.2018.
 */
public interface ApplianceService {
    int addNewAppliance(List applianceInfo) throws ApplianceServiceException, InvalidApplianceException;

    void deleteAppliance(Integer applianceId) throws ApplianceServiceException;

    List<Appliance> getTopAppliances(String language, Object page) throws ApplianceServiceException, InvalidApplianceException;

    List<Appliance> getAppliancesByType(Object typeId, Object page, String language) throws InvalidApplianceException, ApplianceServiceException;
}
