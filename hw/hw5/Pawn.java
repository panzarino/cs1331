/**
 * Represents a Pawn
 * @author zpanzarino3
 * @version 1.0.0
 */
public class Pawn extends Piece {

    /**
     * Creates a new Pawn
     * @param c color of peice
     */
    public Pawn(Color c) {
        super(c);
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
        return getColor() == Color.WHITE ? "P" : "p";
    }

    /**
     * Determines possible move locations given starting position
     * @param square Starting positon
     * @return array of possible moves
     */
    @Override
    public Square[] movesFrom(Square square) {
        char rank = square.getRank();
        char file = square.getFile();
        if (getColor() == Color.WHITE) {
            if (rank == '8') {
                return new Square[0];
            } else if (rank == '2') {
                return new Square[]{
                    new Square(file, '4'),
                    new Square(file, '3')
                };
            } else {
                return new Square[]{new Square(file, (char) (rank + 1))};
            }
        } else {
            if (rank == '1') {
                return new Square[0];
            } else if (rank == '7') {
                return new Square[]{
                    new Square(file, '5'),
                    new Square(file, '6')
                };
            } else {
                return new Square[]{new Square(file, (char) (rank - 1))};
            }
        }
    }
}
