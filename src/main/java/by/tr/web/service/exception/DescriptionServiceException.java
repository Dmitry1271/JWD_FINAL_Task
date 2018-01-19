package by.tr.web.service.exception;

/**
 * Created by cplus on 16.01.2018.
 */
public class DescriptionServiceException extends ServiceException {
    private static final long serialVersionUID = -8869263381390060930L;

    public DescriptionServiceException() {
    }

    public DescriptionServiceException(String message) {
        super(message);
    }

    public DescriptionServiceException(Exception e) {
        super(e);
    }

    public DescriptionServiceException(String message, Exception e) {
        super(message, e);
    }
}
