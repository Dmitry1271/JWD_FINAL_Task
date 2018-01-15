package by.tr.web.service.valid.impl;

import by.tr.web.service.valid.ValidatorDirector;
import by.tr.web.service.valid.ValidatorName;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by cplus on 23.11.2017.
 */
public class LoginValidatorTest {
    @Test
    public void isValidData() throws Exception {
        ValidatorDirector validatorDirector = new ValidatorDirector();
        boolean actual = validatorDirector.takeValidator(ValidatorName.LOGIN).isValidData("rewqr12_3w");
        Assert.assertTrue(actual);
    }
    @Test
    public void isValidData1() throws Exception {
        ValidatorDirector validatorDirector = new ValidatorDirector();
        boolean actual = validatorDirector.takeValidator(ValidatorName.LOGIN).isValidData("Dmitry_12");
        Assert.assertTrue(actual);
    }
    @Test
    public void isValidData2() throws Exception {
        ValidatorDirector validatorDirector = new ValidatorDirector();
        boolean actual = validatorDirector.takeValidator(ValidatorName.LOGIN).isValidData("-ewrdfs");
        Assert.assertFalse(actual);
    }
    @Test
    public void isValidData3() throws Exception {
        ValidatorDirector validatorDirector = new ValidatorDirector();
        boolean actual = validatorDirector.takeValidator(ValidatorName.LOGIN).isValidData("asiuf#$%fdas");
        Assert.assertFalse(actual);
    }

}