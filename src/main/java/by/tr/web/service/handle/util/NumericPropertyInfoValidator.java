package by.tr.web.service.handle.util;

import by.tr.web.service.valid.ValidatorDirector;
import by.tr.web.service.valid.ValidatorName;

import java.util.List;

/**
 * Created by cplus on 14.01.2018.
 */
public final class NumericPropertyInfoValidator {
    private NumericPropertyInfoValidator() {
    }

    public static boolean isValidData(List numericPropertyInfo) {
        ValidatorDirector validatorDirector = new ValidatorDirector();
        int numberValid = 0;
        for (Object elem : numericPropertyInfo) {
            if (validatorDirector.takeValidator(ValidatorName.NUMBER).isValidData(elem)) {
                numberValid++;
            }
        }
        return numberValid == numericPropertyInfo.size();
    }
}
