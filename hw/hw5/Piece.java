/**
 * Represents a chess piece
 * @author zpanzarino3
 * @version 1.0.0
 */
public abstract class Piece {
    private Color color;

    /**
     * Creates new peice of corresponding color
     * @param c Color of Piece
     */
    public Piece(Color c) {
        color = c;
    }

    /**
     * Gets color of piece
     * @return color of peice
     */
    public Color getColor() {
        return color;
    }

    /**
     * Determines if piece is in board
     * @param file file of square
     * @param rank rank of square
     * @return whether piece is in board
     */
    public boolean isInBoard(char file, char rank) {
        return file >= 'a' && file <= 'h' && rank >= '1' && rank <= '8';
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

    /**
     * Converts piece into string
     * @return string representation of peice
     */
    public String toString() {
        return color.toString() + " " + this.getClass();
    }
}
