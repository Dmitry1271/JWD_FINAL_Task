package by.tr.web.dao.exception;

/**
 * Created by cplus on 30.12.2017.
 */
public class UserDAOException extends DAOException {
    private static final long serialVersionUID = -9208022554964773859L;

    public UserDAOException() {
    }

    public UserDAOException(String message) {
        super(message);
    }

    public UserDAOException(Exception e) {
        super(e);
    }

    public UserDAOException(String message, Exception e) {
        super(message, e);
    }
}
