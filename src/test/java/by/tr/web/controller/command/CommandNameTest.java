package by.tr.web.controller.command;

import org.junit.Assert;
import org.junit.Test;


/**
 * Created by cplus on 22.11.2017.
 */
public class CommandNameTest {
    @Test
    public void containsCommand() throws Exception {
        boolean actual = CommandName.containsCommand("CHANGE_LANGUAGE");
        Assert.assertTrue(actual);
    }

    @Test
    public void containsCommand1() throws Exception {
        boolean actual = CommandName.containsCommand("change_language");
        Assert.assertTrue(actual);
    }

    @Test
    public void containsCommand2() throws Exception {
        boolean actual = CommandName.containsCommand("qwezdfsfaoe");
        Assert.assertFalse(actual);
    }

}