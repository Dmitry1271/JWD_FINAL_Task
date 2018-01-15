package by.tr.web.service.exception;

/**
 * Created by cplus on 16.11.2017.
 */
public class ServiceException extends Exception {
    private static final long serialVersionUID = 7566145117320728954L;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Exception e) {
        super(e);
    }

    public ServiceException(String message, Exception e) {
        super(message, e);
    }
}
