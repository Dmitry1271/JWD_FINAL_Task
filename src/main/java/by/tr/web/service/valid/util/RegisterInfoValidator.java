package by.tr.web.service.valid.util;

import by.tr.web.service.valid.ValidatorDirector;
import by.tr.web.service.valid.ValidatorName;

import java.util.List;

/**
 * Created by cplus on 23.11.2017.
 */
public final class RegisterInfoValidator {
    private static final int LOGIN = 0;
    private static final int EMAIL = 1;
    private static final int PASSWORD = 2;
    private static final int CONFIRM_PASSWORD = 3;
    private static final int PHONE_NUMBER = 4;

    private RegisterInfoValidator() {
    }

    public static boolean isValidData(List info) {
        ValidatorDirector validatorDirector = new ValidatorDirector();
        boolean login = validatorDirector.takeValidator(ValidatorName.LOGIN).isValidData(info.get(LOGIN));
        boolean email = validatorDirector.takeValidator(ValidatorName.EMAIL).isValidData(info.get(EMAIL));
        boolean password = false;

        if (info.get(PASSWORD).equals(info.get(CONFIRM_PASSWORD))) {
            password = validatorDirector.takeValidator(ValidatorName.PASSWORD).isValidData(info.get(PASSWORD));
        }

        boolean phoneNumber = validatorDirector.takeValidator(ValidatorName.PHONE_NUMBER).isValidData(info.get(PHONE_NUMBER));
        return login && email && password && phoneNumber;
    }
}
