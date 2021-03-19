public class FamilyOverflowException extends RuntimeException {
    public FamilyOverflowException() {
    }

    public FamilyOverflowException(String message) {
        super(message);
    }

    public FamilyOverflowException(String message, Throwable cause) {
        super(message, cause);
    }

    public FamilyOverflowException(Throwable cause) {
        super(cause);
    }

    public FamilyOverflowException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
