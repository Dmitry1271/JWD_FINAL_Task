package by.tr.web.service.exception.valid;

import by.tr.web.service.exception.ServiceException;

/**
 * Created by cplus on 14.01.2018.
 */
public class InvalidApplianceException extends ServiceException {
    private static final long serialVersionUID = 981755621868681800L;

    public InvalidApplianceException() {
    }

    public InvalidApplianceException(String message) {
        super(message);
    }

    public InvalidApplianceException(Exception e) {
        super(e);
    }

    public InvalidApplianceException(String message, Exception e) {
        super(message, e);
    }
}
