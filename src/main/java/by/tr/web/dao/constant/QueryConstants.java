package by.tr.web.dao.constant;

/**
 * Created by cplus on 20.11.2017.
 */
public final class QueryConstants {
    /**
     * SELECT
     */
    public static final String SQL_SELECT_ALL_USER_BY_LOGIN =
            "SELECT iduser, login, password, salt, email, is_banned, is_admin, phone_number, address " +
                    "FROM user " +
                    "WHERE login=?;";
    public static final String SQL_SELECT_ALL_USER_BY_LOGIN_AND_PASSWORD =
            "SELECT iduser, login, email, is_banned, is_admin, phone_number, address " +
                    "FROM user " +
                    "WHERE login=? AND password=?;";
    public static final String SQL_SELECT_ACCESS_TOKEN_BY_VALUE_AND_TIME =
            "SELECT access_token " +
                    "FROM token " +
                    "WHERE access_token = ? AND access_time > NOW();";
    public static final String SQL_SELECT_REFRESH_TOKEN_BY_VALUE_AND_TIME =
            "SELECT refresh_token " +
                    "FROM token " +
                    "WHERE refresh_token = ? AND refresh_time > NOW();";
    public static final String SQL_SELECT_ALL_TYPES_BY_LANGUAGE =
            "SELECT type_name " +
                    "FROM type " +
                    "WHERE language_type = ?;";
    public static final String SQL_SELECT_TYPE_ID_BY_NAME =
            "SELECT idtype " +
                    "FROM type " +
                    "WHERE LOWER(type_name) = LOWER(?);";
    /**
     * INSERT
     */
    public static final String SQL_INSERT_USER =
            "INSERT INTO user (login, password, salt, email, is_banned, is_admin, phone_number, address) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String SQL_INSERT_TYPE_ID_AND_APPLIANCE_ID =
            "INSERT INTO type_has_appliance (`type_idtype`, `appliance_idappliance`) " +
                    "VALUES (?, ?);";
    public static final String SQL_INSERT_DESCRIPTION = "INSERT INTO description (appliance_idappliance, language_lang, description_text) " +
            "VALUES (?, ?, ?);";

    /**
     * UPDATE
     */
    public static final String SQL_UPDATE_TOKEN =
            "UPDATE token SET access_token=?, refresh_token=?, access_time=DATE_ADD(NOW(), INTERVAL 10 SECOND), " +
                    "refresh_time=DATE_ADD(now(), INTERVAL 5 SECOND) WHERE user_iduser=?;";
    /**
     * CALL
     */
    public static final String SQL_CALL_ADD_NEW_APPLIANCE = "CALL add_new_appliance(?, ?, ?, ?, ?)";
    public static final String SQL_CALL_ADD_PROPERTIES = "CALL add_properties(?, ?, ?)";
    public static final String SQL_CALL_GET_TOP_NINE_APPLIANCES = "CALL get_top_nine_appliances(?);";
    /**
     * DELETE
     */
    public static final String SQL_DELETE_APPLIANCE = "DELETE FROM appliance WHERE idappliance = ?;";
    public static final String SQL_DELETE_TYPE_FROM_APPLIANCE = "DELETE FROM type_has_appliance WHERE appliance_idappliance = ?;";
    public static final String SQL_DELETE_DESCRIPTION = "DELETE FROM description WHERE appliance_idappliance= ?;";


    private QueryConstants() {
    }
}
