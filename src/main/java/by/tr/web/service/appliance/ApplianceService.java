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

    List<Appliance> getTopAppliances(String language) throws ApplianceServiceException;
}
