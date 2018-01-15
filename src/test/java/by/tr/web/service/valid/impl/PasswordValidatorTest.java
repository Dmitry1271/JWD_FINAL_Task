package by.tr.web.service.valid.impl;

import by.tr.web.service.valid.ValidatorDirector;
import by.tr.web.service.valid.ValidatorName;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by cplus on 23.11.2017.
 */
public class PasswordValidatorTest {
    @Test
    public void isValidData() throws Exception {
        ValidatorDirector validatorDirector = new ValidatorDirector();
        boolean actual = validatorDirector.takeValidator(ValidatorName.PASSWORD).isValidData("asiFEuf#$adsf%fdas");
        Assert.assertTrue(actual);
    }

    @Test
    public void isValidData1() throws Exception {
        ValidatorDirector validatorDirector = new ValidatorDirector();
        boolean actual = validatorDirector.takeValidator(ValidatorName.PASSWORD).isValidData("yshdfkja#34y2uifNJEHS_+_=");
        Assert.assertTrue(actual);
    }

    @Test
    public void isValidData2() throws Exception {
        ValidatorDirector validatorDirector = new ValidatorDirector();
        boolean actual = validatorDirector.takeValidator(ValidatorName.PASSWORD).isValidData("qw1");
        Assert.assertFalse(actual);
    }

    @Test
    public void isValidData3() throws Exception {
        ValidatorDirector validatorDirector = new ValidatorDirector();
        boolean actual = validatorDirector.takeValidator(ValidatorName.PASSWORD).isValidData("zxcsaa");
        Assert.assertFalse(actual);
    }


}