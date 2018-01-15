package by.tr.web.service.valid.impl;

import by.tr.web.service.valid.DataValidator;

/**
 * Created by cplus on 12.01.2018.
 */
public class NumberValidator implements DataValidator {
    private static final String REGEX = "^[0-9]{1,12}(\\.[0-9]{1,2})?$";

    @Override
    public boolean isValidData(Object value) {
        return value != null && ((String) value).matches(REGEX);
    }
}
