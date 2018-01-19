package by.tr.web.service.handle.impl;

import by.tr.web.service.handle.PropertyHandler;
import by.tr.web.service.handle.constant.PropertyNameConstant;
import by.tr.web.service.handle.util.NumericPropertyInfoValidator;
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
public class MicrowavePropertyHandler implements PropertyHandler {

    @Override
    public Map<String, Object> selectNeedProperties(List allProperties) {
        Map<String, Object> needProperties = new HashMap<>();
        needProperties.put(PropertyNameConstant.HEIGHT_EN, allProperties.get(HEIGHT_EN));
        needProperties.put(PropertyNameConstant.WIDTH_EN, allProperties.get(WIDTH_EN));
        needProperties.put(PropertyNameConstant.POWER_EN, allProperties.get(POWER_EN));
        needProperties.put(PropertyNameConstant.COLOR_EN, allProperties.get(COLOR_EN));
        needProperties.put(PropertyNameConstant.DEPTH_EN, allProperties.get(DEPTH_EN));
        needProperties.put(PropertyNameConstant.POWER_RU, allProperties.get(POWER_RU));
        needProperties.put(PropertyNameConstant.WIDTH_RU, allProperties.get(WIDTH_RU));
        needProperties.put(PropertyNameConstant.DEPTH_RU, allProperties.get(DEPTH_RU));
        needProperties.put(PropertyNameConstant.COLOR_RU, allProperties.get(COLOR_RU));
        needProperties.put(PropertyNameConstant.HEIGHT_RU, allProperties.get(HEIGHT_RU));
        return needProperties;
    }

    @Override
    public boolean isValidProperties(List allProperties) {
        List numericProperties = new ArrayList();
        numericProperties.add(allProperties.get(POWER_EN));
        numericProperties.add(allProperties.get(DEPTH_EN));
        numericProperties.add(allProperties.get(WIDTH_EN));
        numericProperties.add(allProperties.get(HEIGHT_EN));
        numericProperties.add(allProperties.get(POWER_RU));
        numericProperties.add(allProperties.get(DEPTH_RU));
        numericProperties.add(allProperties.get(WIDTH_RU));
        numericProperties.add(allProperties.get(HEIGHT_RU));

        ValidatorDirector validatorDirector = new ValidatorDirector();
        boolean validColor = validatorDirector.takeValidator(ValidatorName.STRING).isValidData(allProperties.get(COLOR_EN)) &&
                validatorDirector.takeValidator(ValidatorName.STRING).isValidData(allProperties.get(COLOR_RU));

        return NumericPropertyInfoValidator.isValidData(numericProperties) && validColor;
    }
}
