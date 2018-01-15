package by.tr.web.exception;

/**
 * Created by cplus on 09.01.2018.
 */
public class IncorrectTokenException extends Exception {
    private static final long serialVersionUID = 8093048855031580706L;

    public IncorrectTokenException() {
    }

    public IncorrectTokenException(String message) {
        super(message);
    }

    public IncorrectTokenException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectTokenException(Throwable cause) {
        super(cause);
    }
}
