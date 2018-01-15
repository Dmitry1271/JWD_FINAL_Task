package by.tr.web.service.exception;

/**
 * Created by cplus on 30.12.2017.
 */
public class TokenServiceException extends ServiceException{
    private static final long serialVersionUID = 2664610872501038354L;

    public TokenServiceException() {
    }

    public TokenServiceException(String message) {
        super(message);
    }

    public TokenServiceException(Exception e) {
        super(e);
    }

    public TokenServiceException(String message, Exception e) {
        super(message, e);
    }
}
