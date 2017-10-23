/**
 * Error for when creating an invalid square
 * @author zpanzarino3
 */
public class InvalidSquareException extends RuntimeException {
    /**
     * Creates a new invalid square exception
     *
     * Uses a runtime (unchecked) exception because it is something that a
     * client cannot do anything to recover from (as stated in the java
     * documentation) For example, it is like trying to access an index that
     * does not exist in an array, the client should not be able to access a
     * square that is not on the board. Since ArrayIndexOutOfBoundsException is
     * unchecked, it makes sense that this exception should also be unchecked.
     * @param file file that causes the exception
     * @param rank rank that causes the exception
     */
    public InvalidSquareException(char file, char rank) {
        super("Square " + file + rank + " is not a valid square.");
    }
}
