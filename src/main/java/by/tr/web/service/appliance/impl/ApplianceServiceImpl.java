package by.tr.web.service.appliance.impl;

import by.tr.web.dao.DAOFactory;
import by.tr.web.dao.exception.ApplianceDAOException;
import by.tr.web.entity.Language;
import by.tr.web.entity.appliance.Appliance;
import by.tr.web.service.appliance.ApplianceService;
import by.tr.web.service.exception.ApplianceServiceException;
import by.tr.web.service.exception.valid.InvalidApplianceException;
import by.tr.web.service.valid.ValidatorDirector;
import by.tr.web.service.valid.ValidatorName;
import by.tr.web.service.valid.util.ApplianceInfoValidator;

import java.util.List;

/**
 * Created by cplus on 12.01.2018.
 */
public class ApplianceServiceImpl implements ApplianceService {
    @Override
    public int addNewAppliance(List applianceInfo) throws ApplianceServiceException, InvalidApplianceException {
        if (ApplianceInfoValidator.isValidData(applianceInfo)) {
            DAOFactory instance = DAOFactory.getInstance();
            try {
                return instance.getApplianceDAO().addNewAppliance(applianceInfo);
            } catch (ApplianceDAOException e) {
                throw new ApplianceServiceException(e);
            }
        }
        throw new InvalidApplianceException("Invalid appliance info");
    }

    @Override
    public void deleteAppliance(Integer applianceId) throws ApplianceServiceException {
        if (applianceId != null) {
            DAOFactory instance = DAOFactory.getInstance();
            try {
                instance.getApplianceDAO().deleteAppliance(applianceId);
            } catch (ApplianceDAOException e) {
                throw new ApplianceServiceException(e);
            }
        }
    }

    @Override
    public List<Appliance> getTopAppliances(String language) throws ApplianceServiceException {
        DAOFactory instance = DAOFactory.getInstance();
        try {
            if (new ValidatorDirector().takeValidator(ValidatorName.LANGUAGE).isValidData(language)) {
                return instance.getApplianceDAO().getTopAppliances(language);
            } else {
                return instance.getApplianceDAO().getTopAppliances(Language.DEFAULT.getName());
            }
        } catch (ApplianceDAOException e) {
            throw new ApplianceServiceException(e);
        }
    }
}
