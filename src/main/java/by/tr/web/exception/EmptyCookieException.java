package by.tr.web.exception;

/**
 * Created by cplus on 10.01.2018.
 */
public class EmptyCookieException extends Exception {
    private static final long serialVersionUID = 7342778984256959360L;

    public EmptyCookieException() {
    }

    public EmptyCookieException(String message) {
        super(message);
    }

    public EmptyCookieException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyCookieException(Throwable cause) {
        super(cause);
    }
}
