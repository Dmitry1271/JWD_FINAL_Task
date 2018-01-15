package by.tr.web.service.handle.impl;

import by.tr.web.service.handle.PropertyHandler;
import by.tr.web.service.handle.constant.PropertyNameConstant;
import by.tr.web.service.valid.ValidatorDirector;
import by.tr.web.service.valid.ValidatorName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.tr.web.service.handle.constant.PropertyIndexConstant.*;

/**
 * Created by cplus on 14.01.2018.
 */
public class VacuumCleanerPropertyHandler implements PropertyHandler {
    @Override
    public Map<String, Object> selectNeedProperties(List allProperties) {
        Map<String, Object> needProperties = new HashMap<>();
        needProperties.put(PropertyNameConstant.POWER_EN, allProperties.get(POWER_EN));
        needProperties.put(PropertyNameConstant.COLOR_EN, allProperties.get(COLOR_EN));
        needProperties.put(PropertyNameConstant.CLEANING_TYPE_EN, allProperties.get(CLEANING_TYPE_EN));
        needProperties.put(PropertyNameConstant.POWER_RU, allProperties.get(POWER_RU));
        needProperties.put(PropertyNameConstant.COLOR_RU, allProperties.get(COLOR_RU));
        needProperties.put(PropertyNameConstant.CLEANING_TYPE_RU, allProperties.get(CLEANING_TYPE_RU));
        return needProperties;
    }

    @Override
    public boolean isValidProperties(List allProperties) {
        ValidatorDirector validatorDirector = new ValidatorDirector();
        boolean power = validatorDirector.takeValidator(ValidatorName.NUMBER).isValidData(allProperties.get(POWER_EN)) &&
                validatorDirector.takeValidator(ValidatorName.NUMBER).isValidData(allProperties.get(POWER_RU));
        boolean color = allProperties.get(COLOR_EN) != null &&
                allProperties.get(COLOR_RU) != null;
        boolean cleaningType = allProperties.get(CLEANING_TYPE_EN) != null &&
                allProperties.get(CLEANING_TYPE_RU) != null;

        return power && color && cleaningType;
    }
}
