/**
 * Represents a Queen
 * @author zpanzarino3
 */
public class Queen extends Piece {

    /**
     * Creates a new Queen
     * @param color color of peice
     */
    public Queen(Color color) {
        super(color);
    }

    /**
     * Gets algebraic name of piece
     * @return algebraic name of piece
     */
    @Override
    public String algebraicName() {
        return "Q";
    }

    /**
     * Gets fen name of peice depending on color
     * @return fen name of piece
     */
    @Override
    public String fenName() {
        return (getColor() == Color.WHITE) ? "Q" : "q";
    }

    /**
     * Determines possible move locations given starting position
     * @param square Starting positon
     * @return array of possible moves
     */
    @Override
    public Square[] movesFrom(Square square) {
        Rook rook = new Rook(getColor());
        Bishop bishop = new Bishop(getColor());
        Square[] rookSquares = rook.movesFrom(square);
        Square[] bishopSquares = bishop.movesFrom(square);
        Square[] output = new Square[rookSquares.length + bishopSquares.length];
        for (int i = 0; i < rookSquares.length; i++) {
            output[i] = rookSquares[i];
        }
        for (int i = 0; i < bishopSquares.length; i++) {
            output[i + rookSquares.length] = bishopSquares[i];
        }
        return output;
    }
}
