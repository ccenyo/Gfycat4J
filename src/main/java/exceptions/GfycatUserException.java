package exceptions;

public class GfycatUserException extends GfycatException{
    public GfycatUserException(String errorMessage) {
        super(errorMessage);
    }

    public GfycatUserException(String errorMessage, Object... args) {
        super(errorMessage, args);
    }

    public GfycatUserException(String errorMessage, Throwable errCause) {
        super(errorMessage, errCause);
    }

    public GfycatUserException(Exception e) {
        super(e);
    }
}
