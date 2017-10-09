/**
 * Represents a Bishop
 * @author zpanzarino3
 */
public class Bishop extends Piece {

    /**
     * Creates a new Bishop
     * @param color color of peice
     */
    public Bishop(Color color) {
        super(color);
    }

    /**
     * Gets algebraic name of piece
     * @return algebraic name of piece
     */
    @Override
    public String algebraicName() {
        return "B";
    }

    /**
     * Gets fen name of peice depending on color
     * @return fen name of piece
     */
    @Override
    public String fenName() {
        return (getColor() == Color.WHITE) ? "B" : "b";
    }

    /**
     * Determines possible move locations given starting position
     * @param square Starting positon
     * @return array of possible moves
     */
    @Override
    public Square[] movesFrom(Square square) {
        Square[] output = new Square[15];
        int count = 0;
        int rank = square.getRank();
        int file = square.getFile();
        for (int row = rank, col = file;
            row <= '8' && col <= 'h';
            row++, col++) {
            output[count++] = new Square((char) col, (char) row);
        }
        for (int row = rank, col = file;
            row <= '8' && col >= 'a';
            row++, col--) {
            output[count++] = new Square((char) col, (char) row);
        }
        for (int row = rank, col = file;
            row >= '1' && col <= 'h';
            row--, col++) {
            output[count++] = new Square((char) col, (char) row);
        }
        for (int row = rank, col = file;
            row >= '1' && col >= 'a';
            row--, col--) {
            output[count++] = new Square((char) col, (char) row);
        }
        return cleanArray(output, square);
    }
}
