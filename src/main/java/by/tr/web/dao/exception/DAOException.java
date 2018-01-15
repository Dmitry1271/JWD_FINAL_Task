package by.tr.web.dao.exception;

/**
 * Created by cplus on 16.11.2017.
 */
public class DAOException extends Exception {
    private static final long serialVersionUID = 3730921412140653492L;

    public DAOException() {
        super();
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(Exception e) {
        super(e);
    }

    public DAOException(String message, Exception e) {
        super(message, e);
    }


}
