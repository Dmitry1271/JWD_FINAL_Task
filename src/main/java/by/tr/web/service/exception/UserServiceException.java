package by.tr.web.service.exception;

/**
 * Created by cplus on 30.12.2017.
 */
public class UserServiceException extends ServiceException {
    private static final long serialVersionUID = -60278457604503200L;

    public UserServiceException() {
    }

    public UserServiceException(String message) {
        super(message);
    }

    public UserServiceException(Exception e) {
        super(e);
    }

    public UserServiceException(String message, Exception e) {
        super(message, e);
    }
}
