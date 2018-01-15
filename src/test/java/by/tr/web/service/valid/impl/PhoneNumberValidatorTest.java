package by.tr.web.service.valid.impl;

import by.tr.web.service.valid.ValidatorDirector;
import by.tr.web.service.valid.ValidatorName;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cplus on 23.11.2017.
 */
public class PhoneNumberValidatorTest {
    @Test
    public void isValidData() throws Exception {
        ValidatorDirector validatorDirector = new ValidatorDirector();
        boolean actual = validatorDirector.takeValidator(ValidatorName.PHONE_NUMBER).isValidData("+375256692999");
        Assert.assertTrue(actual);
    }

    @Test
    public void isValidData1() throws Exception {
        ValidatorDirector validatorDirector = new ValidatorDirector();
        boolean actual = validatorDirector.takeValidator(ValidatorName.PHONE_NUMBER).isValidData("375256692999");
        Assert.assertTrue(actual);
    }
    @Test
    public void isValidData2() throws Exception {
        ValidatorDirector validatorDirector = new ValidatorDirector();
        boolean actual = validatorDirector.takeValidator(ValidatorName.PHONE_NUMBER).isValidData("+3752F5669df2999");
        Assert.assertFalse(actual);
    }
    @Test
    public void isValidData3() throws Exception {
        ValidatorDirector validatorDirector = new ValidatorDirector();
        boolean actual = validatorDirector.takeValidator(ValidatorName.PHONE_NUMBER).isValidData("1231");
        Assert.assertFalse(false);
    }
}