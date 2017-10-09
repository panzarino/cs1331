/**
 * Represents a King
 * @author zpanzarino3
 */
public class King extends Piece {

    /**
     * Creates a new King
     * @param color color of peice
     */
    public King(Color color) {
        super(color);
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
        return (getColor() == Color.WHITE) ? "K" : "k";
    }

    /**
     * Determines possible move locations given starting position
     * @param square Starting positon
     * @return array of possible moves
     */
    @Override
    public Square[] movesFrom(Square square) {
        char file = square.getFile();
        char rank = square.getRank();
        char up = (char) (rank - 1);
        char down = (char) (rank + 1);
        char left = (char) (file - 1);
        char right = (char) (file + 1);
        Square[] output = new Square[]{
            new Square(left, up),
            new Square(file, up),
            new Square(rank, up),
            new Square(left, rank),
            new Square(right, rank),
            new Square(left, down),
            new Square(file, down),
            new Square(right, down)
        };
        return cleanArray(output, square);
    }
}
