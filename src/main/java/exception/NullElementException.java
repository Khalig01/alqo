package exception;

public class NullElementException extends RuntimeException{
    public NullElementException() {
    }

    public NullElementException(String message) {
        super(message);
    }

    public NullElementException(String message, Throwable cause) {
        super(message, cause);
    }
}



