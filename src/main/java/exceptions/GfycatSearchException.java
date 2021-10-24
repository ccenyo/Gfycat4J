package exceptions;

public class GfycatSearchException extends GfycatException{
    public GfycatSearchException(String errorMessage) {
        super(errorMessage);
    }

    public GfycatSearchException(String errorMessage, Object... args) {
        super(errorMessage, args);
    }

    public GfycatSearchException(String errorMessage, Throwable errCause) {
        super(errorMessage, errCause);
    }

    public GfycatSearchException(Exception e) {
        super(e);
    }
}
