public class IncorrectEmailException extends RuntimeException {
    public IncorrectEmailException() {
        super();
    }

    public IncorrectEmailException(String message) {
        super(message);
    }
}
