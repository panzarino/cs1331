public class Square {
    private char file, rank;

    public static int colFromLetter(char letter) {
        String letters = "abcdefgh";
        return letters.indexOf(letter);
    }

    Square(char file, char rank) {
        this.file = file;
        this.rank = rank;
    }

    Square(String name) {
        this(name.charAt(0), name.charAt(1));
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
