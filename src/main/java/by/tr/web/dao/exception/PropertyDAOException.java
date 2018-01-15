package by.tr.web.dao.exception;

/**
 * Created by cplus on 14.01.2018.
 */
public class PropertyDAOException extends DAOException {
    private static final long serialVersionUID = 1348308092637259016L;

    public PropertyDAOException() {
    }

    public PropertyDAOException(String message) {
        super(message);
    }

    public PropertyDAOException(Exception e) {
        super(e);
    }

    public PropertyDAOException(String message, Exception e) {
        super(message, e);
    }
}
