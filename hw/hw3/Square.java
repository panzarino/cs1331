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
    Square(char file, char rank) {
        this("" + file + rank);
    }

    /**
     * Creates a new square
     * @param name string representation of rank and file
     */
    Square(String name) {
        char f = name.charAt(0);
        char r = name.charAt(1);
        if (f < 'a' || f > 'h' || r < '1' || r > '8' || name.length() > 2) {
            throw new InvalidSquareException(f, r);
        }
        file = f;
        rank = r;
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
}
