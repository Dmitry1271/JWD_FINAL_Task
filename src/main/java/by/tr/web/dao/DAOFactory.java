package by.tr.web.dao;

import by.tr.web.dao.appliance.ApplianceDAO;
import by.tr.web.dao.appliance.impl.ApplianceDAOImpl;
import by.tr.web.dao.description.DescriptionDAO;
import by.tr.web.dao.description.impl.DescriptionDAOImpl;
import by.tr.web.dao.property.PropertyDAO;
import by.tr.web.dao.property.impl.PropertyDAOImpl;
import by.tr.web.dao.type.TypeDAO;
import by.tr.web.dao.type.impl.TypeDAOImpl;
import by.tr.web.dao.authorization.TokenDAO;
import by.tr.web.dao.authorization.UserDAO;
import by.tr.web.dao.authorization.impl.TokenDAOImpl;
import by.tr.web.dao.authorization.impl.UserDAOImpl;

/**
 * Created by cplus on 16.11.2017.
 */
public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private UserDAO userDAO = new UserDAOImpl();
    private TokenDAO tokenDAO = new TokenDAOImpl();
    private TypeDAO typeDAO = new TypeDAOImpl();
    private ApplianceDAO applianceDAO = new ApplianceDAOImpl();
    private PropertyDAO propertyDAO = new PropertyDAOImpl();
    private DescriptionDAO descriptionDAO = new DescriptionDAOImpl();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public TokenDAO getTokenDAO() {
        return tokenDAO;
    }

    public TypeDAO getTypeDAO() {
        return typeDAO;
    }

    public ApplianceDAO getApplianceDAO() {
        return applianceDAO;
    }

    public PropertyDAO getPropertyDAO() {
        return propertyDAO;
    }

    public DescriptionDAO getDescriptionDAO() {
        return descriptionDAO;
    }
}
