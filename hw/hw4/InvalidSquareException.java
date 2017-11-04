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
     * @param name name of file that causes the exception
     */
    public InvalidSquareException(String name) {
        super("Square " + name + " is not a valid square.");
    }
}
