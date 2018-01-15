package by.tr.web.dao.exception;

/**
 * Created by cplus on 12.01.2018.
 */
public class ApplianceDAOException extends DAOException{
    private static final long serialVersionUID = 6255091340345984355L;

    public ApplianceDAOException() {
    }

    public ApplianceDAOException(String message) {
        super(message);
    }

    public ApplianceDAOException(Exception e) {
        super(e);
    }

    public ApplianceDAOException(String message, Exception e) {
        super(message, e);
    }
}
