package by.tr.web.service.description.impl;

import by.tr.web.dao.DAOFactory;
import by.tr.web.dao.exception.DescriptionDAOException;
import by.tr.web.entity.Language;
import by.tr.web.service.description.DescriptionService;
import by.tr.web.service.exception.DescriptionServiceException;
import by.tr.web.service.valid.ValidatorDirector;
import by.tr.web.service.valid.ValidatorName;

import java.util.Map;

/**
 * Created by cplus on 16.01.2018.
 */
public class DescriptionServiceImpl implements DescriptionService {
    @Override
    public void addDescription(Map<Language, String> descriptions, Integer applianceId) throws DescriptionServiceException {
        if (new ValidatorDirector().takeValidator(ValidatorName.DESCRIPTION).isValidData(descriptions)) {
            DAOFactory instance = DAOFactory.getInstance();
            try {
                instance.getDescriptionDAO().addDescription(descriptions, applianceId);
            } catch (DescriptionDAOException e) {
                throw new DescriptionServiceException(e);
            }
        }
    }

    @Override
    public void deleteDescription(Integer applianceId) throws DescriptionServiceException {
        if (applianceId != null) {
            DAOFactory instance = DAOFactory.getInstance();
            try {
                instance.getDescriptionDAO().deleteDescription(applianceId);
            } catch (DescriptionDAOException e) {
                throw new DescriptionServiceException(e);
            }
        }
    }
}
