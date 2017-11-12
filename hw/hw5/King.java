/**
 * Represents a King
 * @author zpanzarino3
 * @version 1.0.0
 */
public class King extends Piece {

    /**
     * Creates a new King
     * @param c color of peice
     */
    public King(Color c) {
        super(c);
    }

    /**
     * Gets algebraic name of piece
     * @return algebraic name of piece
     */
    @Override
    public String algebraicName() {
        return "K";
    }

    /**
     * Gets fen name of peice depending on color
     * @return fen name of piece
     */
    @Override
    public String fenName() {
        return getColor() == Color.WHITE ? "K" : "k";
    }

    /**
     * Determines possible move locations given starting position
     * @param square Starting positon
     * @return array of possible moves
     */
    @Override
    public Square[] movesFrom(Square square) {
        Square[] sq = new Square[8];
        int counter = 0;
        char rank = square.getRank();
        char file = square.getFile();
        for (int r = -1; r <= 1; r++) {
            for (int c = -1; c <= 1; c++) {
                if (r == 0 && c == 0) {
                    continue;
                }
                if (isInBoard((char) (file + c), (char) (rank + r))) {
                    sq[counter++] = new Square(
                        (char) (file + c), (char) (rank + r)
                    );
                }
            }
        }

        Square[] full = new Square[counter];
        for (int i = 0; i < counter; i++) {
            full[i] = sq[i];
        }

        return full;
    }
}
