package by.tr.web.service.exception.valid;

import by.tr.web.service.exception.ServiceException;

/**
 * Created by cplus on 14.01.2018.
 */
public class InvalidTypeException extends ServiceException{
    private static final long serialVersionUID = -5042606228226810796L;

    public InvalidTypeException() {
    }

    public InvalidTypeException(String message) {
        super(message);
    }

    public InvalidTypeException(Exception e) {
        super(e);
    }

    public InvalidTypeException(String message, Exception e) {
        super(message, e);
    }
}
