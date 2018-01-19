package by.tr.web.dao.exception;

/**
 * Created by cplus on 16.01.2018.
 */
public class DescriptionDAOException extends DAOException {
    private static final long serialVersionUID = -7453569019699710447L;

    public DescriptionDAOException() {
    }

    public DescriptionDAOException(String message) {
        super(message);
    }

    public DescriptionDAOException(Exception e) {
        super(e);
    }

    public DescriptionDAOException(String message, Exception e) {
        super(message, e);
    }
}
