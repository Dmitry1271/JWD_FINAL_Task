package by.tr.web.dao.exception;

/**
 * Created by cplus on 10.01.2018.
 */
public class TypeDAOException extends DAOException{
    private static final long serialVersionUID = 6255091340345984355L;

    public TypeDAOException() {
    }

    public TypeDAOException(String message) {
        super(message);
    }

    public TypeDAOException(Exception e) {
        super(e);
    }

    public TypeDAOException(String message, Exception e) {
        super(message, e);
    }
}
