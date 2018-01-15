package by.tr.web.dao.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by cplus on 18.11.2017.
 */
public final class DBConnector {
    private static final String PROPERTY_FILE_NAME = "database/database";
    private static final String URL = "db.url";
    private static final String USER = "db.user";
    private static final String PASSWORD = "db.password";
    private static final String DRIVER = "db.driver";

    private DBConnector() {
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        ResourceBundle resource = ResourceBundle.getBundle(PROPERTY_FILE_NAME);
        String url = resource.getString(URL);
        String user = resource.getString(USER);
        String password = resource.getString(PASSWORD);
        String driver = resource.getString(DRIVER);
        Class.forName(driver);
        return DriverManager.getConnection(url, user, password);
    }
}
