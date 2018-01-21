package by.tr.web.service.exception.valid;

import by.tr.web.service.exception.ServiceException;

/**
 * Created by cplus on 21.01.2018.
 */
public class InvalidUserInfoException extends ServiceException {
    private static final long serialVersionUID = 4579418981769733428L;

    public InvalidUserInfoException() {
    }

    public InvalidUserInfoException(String message) {
        super(message);
    }

    public InvalidUserInfoException(Exception e) {
        super(e);
    }

    public InvalidUserInfoException(String message, Exception e) {
        super(message, e);
    }
}
