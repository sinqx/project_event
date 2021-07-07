package kg.itacademy.demo.exception;

public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(String message) {
        super(message);
    }

    public ObjectNotFoundException(String message, String username) {
        super(message + username);
    }
}
