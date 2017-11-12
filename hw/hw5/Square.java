/**
 * Represents a square on a chess board
 * @author zpanzarino3
 * @version 1.0.0
 */
public class Square {
    private char rank;
    private char file;
    private String name;

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
        this.name = name;
        if (name != null && name.length() == 2) {
            file = name.charAt(0);
            rank = name.charAt(1);
            if (file >= 'a' && file <= 'h' && rank >= '1' && rank <= '8') {
                this.name = name;

            } else {
                throw new InvalidSquareException(name);
            }
        } else {
            throw new InvalidSquareException(name);
        }
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
        return name;
    }

    /**
     * Checks if two squares are equals
     * @param o Object to be compared
     * @return whether objects are equal
     */
    public boolean equals(Object o) {
        if (o instanceof Square) {
            Square that = (Square) o;
            return that.rank == rank && that.file == file;
        } else {
            return false;
        }
    }

    /**
     * Generates hash code for Square
     * @return hash code
     */
    public int hashCode() {
        return name.hashCode();
    }
}
