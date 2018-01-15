package by.tr.web.service;

import by.tr.web.service.appliance.ApplianceService;
import by.tr.web.service.appliance.impl.ApplianceServiceImpl;
import by.tr.web.service.property.PropertyService;
import by.tr.web.service.property.impl.PropertyServiceImpl;
import by.tr.web.service.type.TypeService;
import by.tr.web.service.type.impl.TypeServiceImpl;
import by.tr.web.service.autorization.TokenService;
import by.tr.web.service.autorization.UserService;
import by.tr.web.service.autorization.impl.UserServiceImpl;
import by.tr.web.service.autorization.impl.TokenServiceImpl;

/**
 * Created by cplus on 16.11.2017.
 */
public class ServiceFactory {
    private static ServiceFactory instance = new ServiceFactory();
    private UserService userService = new UserServiceImpl();
    private TokenService tokenService = new TokenServiceImpl();
    private TypeService typeService = new TypeServiceImpl();
    private ApplianceService applianceService = new ApplianceServiceImpl();
    private PropertyService propertyService = new PropertyServiceImpl();

    public static ServiceFactory getInstance() {
        return instance;
    }

    public UserService getUserService() {
        return userService;
    }

    public TokenService getTokenService() {
        return tokenService;
    }

    public TypeService getTypeService() {
        return typeService;
    }

    public ApplianceService getApplianceService() {
        return applianceService;
    }

    public PropertyService getPropertyService() {
        return propertyService;
    }

    private ServiceFactory() {
    }
}
