package by.tr.web.service.exception;

/**
 * Created by cplus on 14.01.2018.
 */
public class PropertyServiceException extends ServiceException {
    private static final long serialVersionUID = 5871919679163639942L;

    public PropertyServiceException() {
    }

    public PropertyServiceException(String message) {
        super(message);
    }

    public PropertyServiceException(Exception e) {
        super(e);
    }

    public PropertyServiceException(String message, Exception e) {
        super(message, e);
    }
}
