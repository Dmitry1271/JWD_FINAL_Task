package by.tr.web.service.exception;

/**
 * Created by cplus on 11.01.2018.
 */
public class TypeServiceException extends ServiceException {
    private static final long serialVersionUID = 3107990440682489144L;

    public TypeServiceException() {
    }

    public TypeServiceException(String message) {
        super(message);
    }

    public TypeServiceException(Exception e) {
        super(e);
    }

    public TypeServiceException(String message, Exception e) {
        super(message, e);
    }
}
