package by.tr.web.entity;

/**
 * Created by cplus on 16.01.2018.
 */
public enum Language {
    EN("en"), RU("ru"), DEFAULT("en");

    private String name;

    Language(String lang) {
        name = lang;
    }

    public String getName() {
        return name;
    }

}
