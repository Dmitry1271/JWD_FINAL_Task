package by.tr.web.dao.property;

import by.tr.web.dao.exception.PropertyDAOException;

import java.util.List;
import java.util.Map;

/**
 * Created by cplus on 14.01.2018.
 */
public interface PropertyDAO {
    void addProperties(int applianceId, Map<String, Object> properties) throws PropertyDAOException;
}
