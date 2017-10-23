/**
 * Represents a chess piece
 * @author zpanzarino3
 */
public abstract class Piece {
    private Color color;

    /**
     * Creates new peice of corresponding color
     * @param color Color of Piece
     */
    public Piece(Color color) {
        this.color = color;
    }

    /**
     * Gets color of piece
     * @return color of peice
     */
    public Color getColor() {
        return color;
    }

    /**
     * Cleans array of nulls and starting positions
     * @param input Unclean array
     * @param start Starting position
     * @return Clean array
     */
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

    /**
     * Gets algebraic name of piece
     * @return algebraic name of piece
     */
    public abstract String algebraicName();

    /**
     * Gets fen name of peice depending on color
     * @return fen name of piece
     */
    public abstract String fenName();

    /**
     * Determines possible move locations given starting position
     * @param square Starting positon
     * @return array of possible moves
     */
    public abstract Square[] movesFrom(Square square);
}
