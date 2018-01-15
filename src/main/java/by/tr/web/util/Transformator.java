package by.tr.web.util;

/**
 * Created by cplus on 22.11.2017.
 */
public final class Transformator {
    private Transformator(){}

    public static final String getEnumFromString(String command){
        return command.trim().toUpperCase().replace(' ','_');
    }
}
