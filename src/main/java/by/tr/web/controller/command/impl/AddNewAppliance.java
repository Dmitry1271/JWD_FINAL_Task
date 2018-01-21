package by.tr.web.controller.command.impl;

import by.tr.web.controller.command.Command;
import by.tr.web.controller.constant.ParameterConstant;
import by.tr.web.controller.constant.RedirectQueryConstant;
import by.tr.web.entity.Language;
import by.tr.web.service.ServiceFactory;
import by.tr.web.service.exception.ApplianceServiceException;
import by.tr.web.service.exception.DescriptionServiceException;
import by.tr.web.service.exception.PropertyServiceException;
import by.tr.web.service.exception.TypeServiceException;
import by.tr.web.service.exception.valid.InvalidApplianceException;
import by.tr.web.service.exception.valid.InvalidPropertyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cplus on 11.01.2018.
 */
public class AddNewAppliance implements Command {
    private static final Logger logger = LogManager.getLogger(AddNewAppliance.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceFactory instance = ServiceFactory.getInstance();
        Integer applianceId = null;
        try {
            applianceId = instance.getApplianceService().addNewAppliance(getApplianceInfoFromParam(request));

            instance.getTypeService().addAllTypesToAppliance(getTypeInfoFromParam(request), applianceId);

            instance.getDescriptionService().addDescription(getDescriptionInfoFromParam(request), applianceId);

            instance.getPropertyService().addProperties(applianceId, getPropertyInfoFromParam(request),
                    request.getParameter(ParameterConstant.TYPE_EN));

        } catch (ApplianceServiceException | InvalidApplianceException e) {
            logger.error(e);
            //page with another message
        } catch (TypeServiceException e) {
            logger.error(e);
            try {
                instance.getApplianceService().deleteAppliance(applianceId);
                //page with another message
            } catch (ApplianceServiceException e1) {
                logger.fatal(e1);
                //page with another message
            }
        } catch (PropertyServiceException | InvalidPropertyException e) {
            logger.error(e);
            try {
                instance.getTypeService().deleteTypeFromAppliance(applianceId);
                instance.getDescriptionService().deleteDescription(applianceId);
                instance.getApplianceService().deleteAppliance(applianceId);
            } catch (ApplianceServiceException | TypeServiceException | DescriptionServiceException e1) {
                logger.fatal(e1);
                //page with another message
            }

        } catch (DescriptionServiceException e) {
            logger.error(e);
            try {
                instance.getTypeService().deleteTypeFromAppliance(applianceId);
                instance.getApplianceService().deleteAppliance(applianceId);
                //page with another message
            } catch (TypeServiceException | ApplianceServiceException e1) {
                logger.fatal(e1);
                //page with another message
            }
        }
        response.sendRedirect(RedirectQueryConstant.ADMIN_PAGE_QUERY);
    }

    private List getApplianceInfoFromParam(HttpServletRequest request) {
        List applianceInfo = new ArrayList();
        applianceInfo.add(request.getParameter(ParameterConstant.PRICE));
        applianceInfo.add(request.getParameter(ParameterConstant.MODEL));
        applianceInfo.add(request.getParameter(ParameterConstant.NUMBER_AVAILABLE));
        applianceInfo.add(request.getParameter(ParameterConstant.IMAGE));
        applianceInfo.add(request.getParameter(ParameterConstant.DISCOUNT));
        return applianceInfo;
    }

    private List<String> getTypeInfoFromParam(HttpServletRequest request) {
        List<String> typeInfo = new ArrayList<>();
        typeInfo.add(request.getParameter(ParameterConstant.TYPE_EN));
        typeInfo.add(request.getParameter(ParameterConstant.TYPE_RU));
        return typeInfo;
    }

    private List<String> getPropertyInfoFromParam(HttpServletRequest request) {
        List propertyInfo = new ArrayList();
        propertyInfo.add(request.getParameter(ParameterConstant.POWER_EN));
        propertyInfo.add(request.getParameter(ParameterConstant.COLOR_EN));
        propertyInfo.add(request.getParameter(ParameterConstant.HEIGHT_EN));
        propertyInfo.add(request.getParameter(ParameterConstant.WIDTH_EN));
        propertyInfo.add(request.getParameter(ParameterConstant.QUALITY_EN));
        propertyInfo.add(request.getParameter(ParameterConstant.VELOCITY_EN));
        propertyInfo.add(request.getParameter(ParameterConstant.DEPTH_EN));
        propertyInfo.add(request.getParameter(ParameterConstant.CLEANING_TYPE_EN));
        propertyInfo.add(request.getParameter(ParameterConstant.POWER_RU));
        propertyInfo.add(request.getParameter(ParameterConstant.COLOR_RU));
        propertyInfo.add(request.getParameter(ParameterConstant.HEIGHT_RU));
        propertyInfo.add(request.getParameter(ParameterConstant.WIDTH_RU));
        propertyInfo.add(request.getParameter(ParameterConstant.QUALITY_RU));
        propertyInfo.add(request.getParameter(ParameterConstant.VELOCITY_RU));
        propertyInfo.add(request.getParameter(ParameterConstant.DEPTH_RU));
        propertyInfo.add(request.getParameter(ParameterConstant.CLEANING_TYPE_RU));
        return propertyInfo;
    }

    private Map<Language, String> getDescriptionInfoFromParam(HttpServletRequest request) {
        Map<Language, String> descriptions = new HashMap<>();
        descriptions.put(Language.EN, request.getParameter(ParameterConstant.DESCRIPTION_EN));
        descriptions.put(Language.RU, request.getParameter(ParameterConstant.DESCRIPTION_RU));
        return descriptions;
    }
}
