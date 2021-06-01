package exceptions.exeptions;

public class NoSuchGroupException extends Exception{
    public NoSuchGroupException() {
    }

    public NoSuchGroupException(String message) {
        super(message);
    }

    public NoSuchGroupException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchGroupException(Throwable cause) {
        super(cause);
    }
}
