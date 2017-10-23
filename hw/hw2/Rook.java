/**
 * Represents a Rook
 * @author zpanzarino3
 */
public class Rook extends Piece {

    /**
     * Creates a new Rook
     * @param color color of peice
     */
    public Rook(Color color) {
        super(color);
    }

    /**
     * Gets algebraic name of piece
     * @return algebraic name of piece
     */
    @Override
    public String algebraicName() {
        return "R";
    }

    /**
     * Gets fen name of peice depending on color
     * @return fen name of piece
     */
    @Override
    public String fenName() {
        return (getColor() == Color.WHITE) ? "R" : "r";
    }

    /**
     * Determines possible move locations given starting position
     * @param square Starting positon
     * @return array of possible moves
     */
    @Override
    public Square[] movesFrom(Square square) {
        Square[] output = new Square[16];
        int count = 0;
        for (int i = 0; i < 8; i++) {
            output[count++] = new Square((char) (97 + i), square.getRank());
            output[count++] = new Square(square.getFile(), (char) (49 + i));
        }
        return cleanArray(output, square);
    }
}
