package by.tr.web.controller.command;

import by.tr.web.util.Transformator;

/**
 * Created by cplus on 16.11.2017.
 */
public enum CommandName {
    SIGN_IN, SIGN_UP, CHANGE_LANGUAGE, GO_HOME_PAGE, GO_SIGN_IN_PAGE, GO_SIGN_UP_PAGE, GO_ADMIN_PAGE,
    ADD_NEW_APPLIANCE, EXIT, GO_PROFILE_PAGE, CHANGE_PROFILE, CHANGE_PASSWORD;

    public static boolean containsCommand(String command){
        String enumCommand = Transformator.getEnumFromString(command);
        for(CommandName elem:values()){
            if (enumCommand.equals(elem.name())){
                return true;
            }
        }
        return false;
    }
}