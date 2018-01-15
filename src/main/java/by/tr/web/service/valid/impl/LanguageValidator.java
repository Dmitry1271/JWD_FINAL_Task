package by.tr.web.service.valid.impl;

import by.tr.web.service.valid.DataValidator;

/**
 * Created by cplus on 11.01.2018.
 */
public class LanguageValidator implements DataValidator{
    private static final String REGEX = "^en|ru$";
    @Override
    public boolean isValidData(Object value) {
        return value != null && ((String) value).matches(REGEX);
    }
}
