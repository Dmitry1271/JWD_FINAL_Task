package by.tr.web.dao.description;

import by.tr.web.dao.exception.DescriptionDAOException;
import by.tr.web.entity.Language;

import java.util.List;
import java.util.Map;

/**
 * Created by cplus on 16.01.2018.
 */
public interface DescriptionDAO {
    void addDescription(Map<Language, String> descriptions, int applianceId) throws DescriptionDAOException;

    void deleteDescription(int applianceId) throws DescriptionDAOException;
}
