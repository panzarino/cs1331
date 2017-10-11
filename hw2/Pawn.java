/**
 * Represents a Pawn
 * @author zpanzarino3
 */
public class Pawn extends Piece {

    /**
     * Creates a new Pawn
     * @param color color of peice
     */
    public Pawn(Color color) {
        super(color);
    }

    /**
     * Gets algebraic name of piece
     * @return algebraic name of piece
     */
    @Override
    public String algebraicName() {
        return "";
    }

    /**
     * Gets fen name of peice depending on color
     * @return fen name of piece
     */
    @Override
    public String fenName() {
        return (getColor() == Color.WHITE) ? "P" : "p";
    }

    /**
     * Determines possible move locations given starting position
     * @param square Starting positon
     * @return array of possible moves
     */
    @Override
    public Square[] movesFrom(Square square) {
        if (getColor() == Color.WHITE) {
            Square one = new Square(
                square.getFile(), (char) (square.getRank() + 1)
            );
            if (square.getRank() == '2') {
                Square two = new Square(
                    square.getFile(), (char) (square.getRank() + 2)
                );
                return cleanArray(new Square[]{one, two}, square);
            }
            return cleanArray(new Square[]{one}, square);
        } else {
            Square one = new Square(
                square.getFile(), (char) (square.getRank() - 1)
            );
            if (square.getRank() == '7') {
                Square two = new Square(
                    square.getFile(), (char) (square.getRank() - 2)
                );
                return cleanArray(new Square[]{one, two}, square);
            }
            return cleanArray(new Square[]{one}, square);
        }
    }
}
