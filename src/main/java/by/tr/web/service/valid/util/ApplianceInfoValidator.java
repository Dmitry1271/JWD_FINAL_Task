package by.tr.web.service.valid.util;

import by.tr.web.service.valid.ValidatorDirector;
import by.tr.web.service.valid.ValidatorName;

import java.util.List;

/**
 * Created by cplus on 12.01.2018.
 */
public final class ApplianceInfoValidator {
    private static final int PRICE = 0;
    private static final int NUMBER_AVAILABLE = 2;
    private static final int DISCOUNT = 4;

    private ApplianceInfoValidator() {
    }

    public static boolean isValidData(List info) {
        ValidatorDirector validatorDirector = new ValidatorDirector();
        boolean price = validatorDirector.takeValidator(ValidatorName.NUMBER).isValidData(info.get(PRICE));
        boolean numberAvailable = validatorDirector.takeValidator(ValidatorName.NUMBER).isValidData(info.get(NUMBER_AVAILABLE));
        boolean discount = validatorDirector.takeValidator(ValidatorName.NUMBER).isValidData(info.get(DISCOUNT));
        return price && numberAvailable && discount;
    }
}
