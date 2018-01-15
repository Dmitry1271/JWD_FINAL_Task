package by.tr.web.controller.util;

import by.tr.web.util.Transformator;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by cplus on 22.11.2017.
 */
public class TransformatorTest {
    @Test
    public void getEnumFromString() throws Exception {
        String expected = "CHANGE_LOCAL";
        String actual = Transformator.getEnumFromString("chaNge_loCAl    ");
        Assert.assertEquals(expected,actual);
    }

}