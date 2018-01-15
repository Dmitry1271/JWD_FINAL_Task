package by.tr.web.service.exception;

/**
 * Created by cplus on 12.01.2018.
 */
public class ApplianceServiceException extends ServiceException {
    private static final long serialVersionUID = 3107990440682489144L;

    public ApplianceServiceException() {
    }

    public ApplianceServiceException(String message) {
        super(message);
    }

    public ApplianceServiceException(Exception e) {
        super(e);
    }

    public ApplianceServiceException(String message, Exception e) {
        super(message, e);
    }
}
