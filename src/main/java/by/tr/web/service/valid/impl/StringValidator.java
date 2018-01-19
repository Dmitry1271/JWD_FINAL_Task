package by.tr.web.service.valid.impl;

import by.tr.web.service.valid.DataValidator;

/**
 * Created by cplus on 16.01.2018.
 */
public class StringValidator implements DataValidator {

    @Override
    public boolean isValidData(Object value) {
        return value != null && !"".equals(value);
    }
}
