package exceptions;

public class GfycatAuthenticationException extends GfycatException{
    public GfycatAuthenticationException(String errorMessage) {
        super(errorMessage);
    }

    public GfycatAuthenticationException(String errorMessage, Object... args) {
        super(errorMessage, args);
    }

    public GfycatAuthenticationException(String errorMessage, Throwable errCause) {
        super(errorMessage, errCause);
    }

    public GfycatAuthenticationException(Exception e) {
        super(e);
    }
}
