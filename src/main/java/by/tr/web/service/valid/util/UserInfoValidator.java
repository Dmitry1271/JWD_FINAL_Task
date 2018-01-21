package by.tr.web.service.valid.util;

import by.tr.web.service.valid.ValidatorDirector;
import by.tr.web.service.valid.ValidatorName;

import java.util.List;

/**
 * Created by cplus on 21.01.2018.
 */
public final class UserInfoValidator {
    private static final int EMAIL = 0;
    private static final int PHONE_NUMBER = 1;

    private UserInfoValidator() {
    }

    public static boolean isValidData(List userInfo) {
        ValidatorDirector validatorDirector = new ValidatorDirector();
        boolean validEmail = validatorDirector.takeValidator(ValidatorName.EMAIL).isValidData(userInfo.get(EMAIL));
        boolean validPhoneNumber = validatorDirector.takeValidator(ValidatorName.PHONE_NUMBER)
                .isValidData(userInfo.get(PHONE_NUMBER));
        return validEmail && validPhoneNumber;
    }
}
