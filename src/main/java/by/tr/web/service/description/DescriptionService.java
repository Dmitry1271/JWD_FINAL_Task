package by.tr.web.service.description;

import by.tr.web.entity.Language;
import by.tr.web.service.exception.DescriptionServiceException;

import java.util.Map;

/**
 * Created by cplus on 16.01.2018.
 */
public interface DescriptionService {
    void addDescription(Map<Language, String> descriptions, Integer applianceId) throws DescriptionServiceException;

    void deleteDescription(Integer applianceId) throws DescriptionServiceException;
}
