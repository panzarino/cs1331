/**
 * Represents a Knight
 * @author zpanzarino3
 */
public class Knight extends Piece {

    /**
     * Creates a new Knight
     * @param color color of peice
     */
    public Knight(Color color) {
        super(color);
    }

    /**
     * Gets algebraic name of piece
     * @return algebraic name of piece
     */
    @Override
    public String algebraicName() {
        return "N";
    }

    /**
     * Gets fen name of peice depending on color
     * @return fen name of piece
     */
    @Override
    public String fenName() {
        return (getColor() == Color.WHITE) ? "N" : "n";
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
        char twoUp = (char) (rank - 2);
        char twoDown = (char) (rank + 2);
        char oneUp = (char) (rank - 1);
        char oneDown = (char) (rank + 1);
        char twoRight = (char) (file + 2);
        char twoLeft = (char) (file - 2);
        char oneRight = (char) (file + 1);
        char oneLeft = (char) (file - 1);
        Square[] output = new Square[]{
            new Square(oneRight, twoUp),
            new Square(oneLeft, twoUp),
            new Square(oneRight, twoDown),
            new Square(oneLeft, twoDown),
            new Square(twoRight, oneUp),
            new Square(twoLeft, oneUp),
            new Square(twoRight, oneDown),
            new Square(twoLeft, oneDown)
        };
        return cleanArray(output, square);
    }
}
