package by.tr.web.service.property;

import by.tr.web.service.exception.PropertyServiceException;
import by.tr.web.service.exception.valid.InvalidPropertyException;

import java.util.List;

/**
 * Created by cplus on 14.01.2018.
 */
public interface PropertyService {
    void addProperties(int applianceId, List propertiesInfo, String typeName) throws PropertyServiceException, InvalidPropertyException;
}
