public abstract class Piece {
    private Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    protected static Square[] cleanArray(Square[] input, Square start) {
        int nullCount = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == null) {
                nullCount++;
            } else {
                char file = input[i].getFile();
                char rank = input[i].getRank();
                if (file > 'h' || file < 'a'
                    || rank > '8' || rank < '1'
                    || input[i].equals(start)) {
                    input[i] = null;
                    nullCount++;
                }
            }
        }
        Square[] output = new Square[input.length - nullCount];
        int count = 0;
        for (Square square : input) {
            if (square != null) {
                output[count++] = square;
            }
        }
        return output;
    }

    public abstract String algebraicName();
    public abstract String fenName();
    public abstract Square[] movesFrom(Square square);
}
