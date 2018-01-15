package by.tr.web.service.valid.impl;

import by.tr.web.service.valid.ValidatorDirector;
import by.tr.web.service.valid.ValidatorName;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cplus on 23.11.2017.
 */
public class EmailValidatorTest {
    @Test
    public void isValidData() throws Exception {
        ValidatorDirector validatorDirector = new ValidatorDirector();
        boolean actual = validatorDirector.takeValidator(ValidatorName.EMAIL).isValidData("sdf123@gmail.com");
        Assert.assertTrue(actual);
    }

    @Test
    public void isValidData1() throws Exception {
        ValidatorDirector validatorDirector = new ValidatorDirector();
        boolean actual = validatorDirector.takeValidator(ValidatorName.EMAIL).isValidData("q.we_qw-o@example.rubl");
        Assert.assertTrue(actual);
    }

    @Test
    public void isValidData2() throws Exception {
        ValidatorDirector validatorDirector = new ValidatorDirector();
        boolean actual = validatorDirector.takeValidator(ValidatorName.EMAIL).isValidData("qwerxqwer@csadf");
        Assert.assertFalse(actual);
    }

    @Test
    public void isValidData3() throws Exception {
        ValidatorDirector validatorDirector = new ValidatorDirector();
        boolean actual = validatorDirector.takeValidator(ValidatorName.EMAIL).isValidData(".sdf123@gmail.com");
        Assert.assertFalse(actual);
    }

    @Test
    public void isValidData4() throws Exception {
        ValidatorDirector validatorDirector = new ValidatorDirector();
        boolean actual = validatorDirector.takeValidator(ValidatorName.EMAIL).isValidData("asdfqwerfaswer");
        Assert.assertFalse(actual);
    }

}