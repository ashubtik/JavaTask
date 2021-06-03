package exceptions.exeptions;

public class NoSuchFacultyException extends Exception {
    public NoSuchFacultyException() {
    }

    public NoSuchFacultyException(String message) {
        super(message);
    }

    public NoSuchFacultyException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchFacultyException(Throwable cause) {
        super(cause);
    }
}
