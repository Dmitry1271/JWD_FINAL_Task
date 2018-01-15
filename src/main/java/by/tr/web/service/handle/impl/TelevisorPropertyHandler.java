package by.tr.web.service.handle.impl;

import by.tr.web.service.handle.PropertyHandler;
import by.tr.web.service.handle.constant.PropertyNameConstant;
import by.tr.web.service.handle.util.NumericPropertyInfoValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.tr.web.service.handle.constant.PropertyIndexConstant.*;

/**
 * Created by cplus on 14.01.2018.
 */
public class TelevisorPropertyHandler implements PropertyHandler {

    @Override
    public Map<String, Object> selectNeedProperties(List allProperties) {
        Map<String, Object> needProperties = new HashMap<>();
        needProperties.put(PropertyNameConstant.HEIGHT_EN, allProperties.get(HEIGHT_EN));
        needProperties.put(PropertyNameConstant.WIDTH_EN, allProperties.get(WIDTH_EN));
        needProperties.put(PropertyNameConstant.QUALITY_EN, allProperties.get(QUALITY_EN));
        needProperties.put(PropertyNameConstant.WIDTH_RU, allProperties.get(WIDTH_RU));
        needProperties.put(PropertyNameConstant.HEIGHT_RU, allProperties.get(HEIGHT_RU));
        needProperties.put(PropertyNameConstant.QUALITY_RU, allProperties.get(QUALITY_RU));
        return needProperties;
    }

    @Override
    public boolean isValidProperties(List allProperties) {
        List numericProperties = new ArrayList();
        numericProperties.add(allProperties.get(WIDTH_EN));
        numericProperties.add(allProperties.get(HEIGHT_EN));
        numericProperties.add(allProperties.get(WIDTH_RU));
        numericProperties.add(allProperties.get(HEIGHT_RU));
        boolean quality = allProperties.get(QUALITY_EN) != null &&
                allProperties.get(QUALITY_RU) != null;
        return NumericPropertyInfoValidator.isValidData(numericProperties) && quality;
    }
}
