
/**
 * Custom exception when the rover moves out of bounds.
 */
public class OutOfBoundsException extends Exception {
    public OutOfBoundsException(String message) {
        super(message);
    }
}