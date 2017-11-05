/**
 * Represents a square on a chess board
 * @author zpanzarino3
 */
public class Square {
    private char file;
    private char rank;

    /**
     * Creates a new square
     * @param file file as a letter represents column
     * @param rank rank as a number represents row
     */
    public Square(char file, char rank) {
        this("" + file + rank);
    }

    /**
     * Creates a new square
     * @param name string representation of rank and file
     */
    public Square(String name) {
        if (name.length() != 2
            || name.charAt(0) < 'a' || name.charAt(0) > 'h'
            || name.charAt(1) < '1' || name.charAt(1) > '8'
            ) {
            throw new InvalidSquareException(name);
        }
        file = name.charAt(0);
        rank = name.charAt(1);
    }

    /**
     * Gets the file of the square
     * @return file of square
     */
    public char getFile() {
        return file;
    }

    /**
     * Gets the rank of the square
     * @return rank of square
     */
    public char getRank() {
        return rank;
    }

    /**
     * Returns string representation of square
     * @return string representation of rank and file
     */
    public String toString() {
        return "" + file + rank;
    }

    /**
     * Checks if two squares are equals
     * @param other Object to be compared
     * @return boolean
     */
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof Square)) {
            return false;
        }
        Square that = (Square) other;
        return file == that.file && rank == that.rank;
    }

    /**
     * Returns a hashcode value for the square
     * @return hashcode
     */
    public int hashCode() {
        return toString().hashCode();
    }
}
