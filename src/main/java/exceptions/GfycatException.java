package exceptions;


public class GfycatException extends RuntimeException {

    public GfycatException(String errorMessage) {
        super(errorMessage);
    }

    public GfycatException(String errorMessage, Object... args) {
        super(String.format(errorMessage, args));
    }

    public GfycatException(String errorMessage, Throwable errCause) {
        super(errorMessage, errCause);
    }

    public GfycatException(Exception e) {
        super(e);
    }
}
