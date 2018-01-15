package by.tr.web.service.valid.impl;

import by.tr.web.service.valid.DataValidator;

/**
 * Created by cplus on 23.11.2017.
 */
public class PasswordValidator implements DataValidator {
    private static final String REGEX = "^.{8,60}$";

    @Override
    public boolean isValidData(Object value) {
        return value != null && ((String) value).matches(REGEX);
    }
}
