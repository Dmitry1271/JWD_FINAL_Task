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
        boolean validPower = validatorDirector.takeValidator(ValidatorName.NUMBER).isValidData(allProperties.get(POWER_EN)) &&
                validatorDirector.takeValidator(ValidatorName.NUMBER).isValidData(allProperties.get(POWER_RU));

        boolean validCleaningType = validatorDirector.takeValidator(ValidatorName.STRING).isValidData(allProperties.get(CLEANING_TYPE_EN)) &&
                validatorDirector.takeValidator(ValidatorName.STRING).isValidData(allProperties.get(CLEANING_TYPE_RU));

        boolean validColor = validatorDirector.takeValidator(ValidatorName.STRING).isValidData(allProperties.get(COLOR_EN)) &&
                validatorDirector.takeValidator(ValidatorName.STRING).isValidData(allProperties.get(COLOR_RU));

        return validPower && validColor && validCleaningType;
    }
}
