package by.tr.web.service.valid.impl;

import by.tr.web.entity.Language;
import by.tr.web.service.valid.DataValidator;

import java.util.Map;

/**
 * Created by cplus on 16.01.2018.
 */
public class DescriptionValidator implements DataValidator {
    @Override
    public boolean isValidData(Object value) {
        Map<Language, String> descriptions = (Map<Language, String>) value;
        int valid = 0;
        for (Language language : descriptions.keySet()) {
            if (descriptions.get(language) != null && !"".equals(descriptions.get(language))) {
                valid++;
            }
        }
        return valid == descriptions.size();
    }
}
