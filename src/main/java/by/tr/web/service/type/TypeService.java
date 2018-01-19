package by.tr.web.service.type;

import by.tr.web.service.exception.TypeServiceException;
import by.tr.web.service.exception.valid.InvalidTypeException;

import java.util.List;

/**
 * Created by cplus on 11.01.2018.
 */
public interface TypeService {
    List<String> getAllTypes(String language) throws TypeServiceException, InvalidTypeException;

    void addAllTypesToAppliance(List<String> typeNames, Integer applianceId) throws TypeServiceException;

    void deleteTypeFromAppliance(Integer applianceId) throws TypeServiceException;
}
