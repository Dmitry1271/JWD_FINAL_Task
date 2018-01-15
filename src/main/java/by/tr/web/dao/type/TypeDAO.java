package by.tr.web.dao.type;

import by.tr.web.dao.exception.TypeDAOException;

import java.util.List;
import java.util.Map;

/**
 * Created by cplus on 10.01.2018.
 */
public interface TypeDAO {
    List<String> getAllTypes(String language) throws TypeDAOException;

    int getTypeId(String typeName) throws TypeDAOException;

    void addTypeToAppliance(List<Integer> listTypeId, int applianceId) throws TypeDAOException;

    void deleteTypeFromAppliance(int applianceId) throws TypeDAOException;

}
