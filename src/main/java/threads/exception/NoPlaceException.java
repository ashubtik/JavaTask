package threads.exception;

public class NoPlaceException extends Exception {
    public NoPlaceException() {
    }

    public NoPlaceException(String message) {
        super(" got tired of waiting and drove off to look for another parking");
    }

    public NoPlaceException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoPlaceException(Throwable cause) {
        super(cause);
    }
}
