package by.tr.web.dao.exception;

/**
 * Created by cplus on 30.12.2017.
 */
public class TokenDAOException extends DAOException {
    private static final long serialVersionUID = -1659330244992715666L;

    public TokenDAOException() {
    }

    public TokenDAOException(String message) {
        super(message);
    }

    public TokenDAOException(Exception e) {
        super(e);
    }

    public TokenDAOException(String message, Exception e) {
        super(message, e);
    }
}
