package by.tr.web.controller.command;

import by.tr.web.controller.command.impl.*;
import by.tr.web.util.Transformator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cplus on 16.11.2017.
 */
public class CommandDirector {
    private Map<CommandName, Command> commands = new HashMap<>();

    public CommandDirector() {
        commands.put(CommandName.SIGN_IN, new SignIn());
        commands.put(CommandName.SIGN_UP, new SignUp());
        commands.put(CommandName.GO_HOME_PAGE, new GoHomePage());
        commands.put(CommandName.CHANGE_LANGUAGE, new ChangeLanguage());
        commands.put(CommandName.GO_SIGN_IN_PAGE, new GoSignInPage());
        commands.put(CommandName.GO_SIGN_UP_PAGE, new GoSignUpPage());
        commands.put(CommandName.GO_ADMIN_PAGE, new GoAdminPage());
        commands.put(CommandName.ADD_NEW_APPLIANCE, new AddNewAppliance());
    }

    public Command getCommand(String name) {
        CommandName commandName = CommandName.valueOf(Transformator.getEnumFromString(name));
        return commands.get(commandName);
    }
}
