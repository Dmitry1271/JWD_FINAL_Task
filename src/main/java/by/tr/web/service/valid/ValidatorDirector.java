package by.tr.web.service.valid;

import by.tr.web.service.valid.impl.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cplus on 23.11.2017.
 */
public class ValidatorDirector {
    Map<ValidatorName, DataValidator> validators = new HashMap<>();

    public ValidatorDirector() {
        validators.put(ValidatorName.LOGIN, new LoginValidator());
        validators.put(ValidatorName.PASSWORD, new PasswordValidator());
        validators.put(ValidatorName.EMAIL, new EmailValidator());
        validators.put(ValidatorName.PHONE_NUMBER, new PhoneNumberValidator());
        validators.put(ValidatorName.LANGUAGE, new LanguageValidator());
        validators.put(ValidatorName.NUMBER, new NumberValidator());
        validators.put(ValidatorName.DESCRIPTION, new DescriptionValidator());
        validators.put(ValidatorName.STRING, new StringValidator());
    }

    public DataValidator takeValidator(ValidatorName name) {
        return validators.get(name);
    }
}
