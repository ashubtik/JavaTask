package exceptions.exeptions;

public class MarkOutOfBoundException extends Exception {
    public MarkOutOfBoundException() {
    }

    public MarkOutOfBoundException(String message) {
        super(message);
    }

    public MarkOutOfBoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MarkOutOfBoundException(Throwable cause) {
        super(cause);
    }
}
