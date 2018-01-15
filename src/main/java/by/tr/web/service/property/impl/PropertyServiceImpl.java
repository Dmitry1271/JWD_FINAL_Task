package by.tr.web.service.property.impl;

import by.tr.web.dao.DAOFactory;
import by.tr.web.dao.exception.PropertyDAOException;
import by.tr.web.service.exception.PropertyServiceException;
import by.tr.web.service.exception.valid.InvalidPropertyException;
import by.tr.web.service.handle.HandlerDirector;
import by.tr.web.service.handle.PropertyHandler;
import by.tr.web.service.property.PropertyService;

import java.util.List;

/**
 * Created by cplus on 14.01.2018.
 */
public class PropertyServiceImpl implements PropertyService {
    @Override
    public void addProperties(int applianceId, List propertiesInfo, String typeName) throws PropertyServiceException, InvalidPropertyException {
        HandlerDirector handlerDirector = new HandlerDirector();
        PropertyHandler propertyHandler = handlerDirector.takeHandler(typeName);
        if (propertyHandler.isValidProperties(propertiesInfo)) {
            DAOFactory instance = DAOFactory.getInstance();
            try {
                instance.getPropertyDAO().addProperties(applianceId, propertyHandler.selectNeedProperties(propertiesInfo));
            } catch (PropertyDAOException e) {
                throw new PropertyServiceException(e);
            }
        } else {
            throw new InvalidPropertyException("Invalid property info");
        }
    }
}
