package by.tr.web.service.appliance.impl;

import by.tr.web.constant.PaginationConstant;
import by.tr.web.controller.constant.ParameterConstant;
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
    public List<Appliance> getTopAppliances(String language, Object page) throws ApplianceServiceException, InvalidApplianceException {
        DAOFactory instance = DAOFactory.getInstance();
        ValidatorDirector validatorDirector = new ValidatorDirector();
        if (validatorDirector.takeValidator(ValidatorName.NUMBER).isValidData(page)) {
            int numericPage = Integer.parseInt((String) page);
            int from = numericPage * (PaginationConstant.NUMBER_APPLIANCES_ON_PAGE_PLUS_ONE - 1);
            try {
                if (validatorDirector.takeValidator(ValidatorName.LANGUAGE).isValidData(language)) {
                    return instance.getApplianceDAO().getTopAppliances(language, from,
                            PaginationConstant.NUMBER_APPLIANCES_ON_PAGE_PLUS_ONE);

                } else {
                    return instance.getApplianceDAO().getTopAppliances(Language.DEFAULT.getName(), from,
                            PaginationConstant.NUMBER_APPLIANCES_ON_PAGE_PLUS_ONE);
                }
            } catch (ApplianceDAOException e) {
                throw new ApplianceServiceException(e);
            }
        }
        throw new InvalidApplianceException("Invalid page");
    }

    @Override
    public List<Appliance> getAppliancesByType(Object typeId, Object page, String language) throws InvalidApplianceException, ApplianceServiceException {
        ValidatorDirector validatorDirector = new ValidatorDirector();
        if (validatorDirector.takeValidator(ValidatorName.NUMBER).isValidData(typeId) &&
                validatorDirector.takeValidator(ValidatorName.NUMBER).isValidData(page)) {

            int numericPage = Integer.parseInt((String) page);
            int from = numericPage * (PaginationConstant.NUMBER_APPLIANCES_ON_PAGE_PLUS_ONE - 1);
            DAOFactory instance = DAOFactory.getInstance();

            try {
                if (validatorDirector.takeValidator(ValidatorName.LANGUAGE).isValidData(language)) {
                    return instance.getApplianceDAO().getAppliancesByType(Integer.parseInt((String) typeId), from,
                            PaginationConstant.NUMBER_APPLIANCES_ON_PAGE_PLUS_ONE, language);
                } else {
                    return instance.getApplianceDAO().getAppliancesByType(Integer.parseInt((String) typeId), from,
                            PaginationConstant.NUMBER_APPLIANCES_ON_PAGE_PLUS_ONE, Language.DEFAULT.getName());
                }
            } catch (ApplianceDAOException e) {
                throw new ApplianceServiceException(e);
            }
        } else {
            throw new InvalidApplianceException("Invalid typeId or page");
        }
    }
}
