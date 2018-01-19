package by.tr.web.service.type.impl;

import by.tr.web.dao.DAOFactory;
import by.tr.web.dao.type.TypeDAO;
import by.tr.web.dao.exception.TypeDAOException;
import by.tr.web.entity.Language;
import by.tr.web.service.exception.valid.InvalidPropertyException;
import by.tr.web.service.exception.valid.InvalidTypeException;
import by.tr.web.service.type.TypeService;
import by.tr.web.service.exception.TypeServiceException;
import by.tr.web.service.valid.ValidatorDirector;
import by.tr.web.service.valid.ValidatorName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cplus on 11.01.2018.
 */
public class TypeServiceImpl implements TypeService {
    @Override
    public List<String> getAllTypes(String language) throws TypeServiceException, InvalidTypeException {
        DAOFactory instance = DAOFactory.getInstance();
        TypeDAO typeDAO = instance.getTypeDAO();
        try {
            if (new ValidatorDirector().takeValidator(ValidatorName.LANGUAGE).isValidData(language)) {
                return typeDAO.getAllTypes(language);
            } else {
                return typeDAO.getAllTypes(Language.DEFAULT.getName());
            }
        } catch (TypeDAOException e) {
            throw new TypeServiceException(e);
        }
    }

    @Override
    public void addAllTypesToAppliance(List<String> typeNames, Integer applianceId) throws TypeServiceException {
        if (applianceId != null) {
            DAOFactory instance = DAOFactory.getInstance();
            List<Integer> listTypeId = new ArrayList<>();
            try {
                for (String typeName : typeNames) {
                    listTypeId.add(instance.getTypeDAO().getTypeId(typeName));
                }
                instance.getTypeDAO().addTypeToAppliance(listTypeId, applianceId);
            } catch (TypeDAOException e) {
                throw new TypeServiceException(e);
            }
        }
    }

    @Override
    public void deleteTypeFromAppliance(Integer applianceId) throws TypeServiceException {
        if (applianceId != null) {
            DAOFactory instance = DAOFactory.getInstance();
            try {
                instance.getTypeDAO().deleteTypeFromAppliance(applianceId);
            } catch (TypeDAOException e) {
                throw new TypeServiceException(e);
            }
        }
    }
}
