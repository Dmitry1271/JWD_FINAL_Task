package by.tr.web.service.exception.valid;

import by.tr.web.service.exception.ServiceException;

/**
 * Created by cplus on 14.01.2018.
 */
public class InvalidPropertyException extends ServiceException {
    private static final long serialVersionUID = 3022365592604197955L;

    public InvalidPropertyException() {
    }

    public InvalidPropertyException(String message) {
        super(message);
    }

    public InvalidPropertyException(Exception e) {
        super(e);
    }

    public InvalidPropertyException(String message, Exception e) {
        super(message, e);
    }
}
