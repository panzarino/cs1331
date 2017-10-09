public class Square {
    private char file;
    private char rank;

    Square(char file, char rank) {
        this.file = file;
        this.rank = rank;
    }

    Square(String name) {
        this(name.charAt(0), name.charAt(1));
    }

    public char getFile() {
        return file;
    }

    public char getRank() {
        return rank;
    }

    public String toString() {
        return "" + file + rank;
    }

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
