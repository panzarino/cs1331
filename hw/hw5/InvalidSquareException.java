/**
 * Error for when creating an invalid square
 * @author zpanzarino3
 * @version 1.0.0
 */
public class InvalidSquareException extends RuntimeException {
    /**
     * Creates a new invalid square exception
     * @param square name of square that causes the exception
     */
    public InvalidSquareException(String square) {
        super(square);
    }
}
