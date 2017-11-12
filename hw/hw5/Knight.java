/**
 * Represents a Knight
 * @author zpanzarino3
 * @version 1.0.0
 */
public class Knight extends Piece {

    /**
     * Creates a new Knight
     * @param c color of peice
     */
    public Knight(Color c) {
        super(c);
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
        return getColor() == Color.WHITE ? "N" : "n";
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
        char[] ranks = new char[]{
            (char) (rank - 2),
            (char) (rank - 1),
            (char) (rank + 1),
            (char) (rank + 2)
        };
        char[] files = new char[]{
            (char) (file - 2),
            (char) (file - 1),
            (char) (file + 1),
            (char) (file + 2)
        };

        if (isInBoard(files[0], ranks[1])) {
            sq[counter++] = new Square(files[0], ranks[1]);
        }
        if (isInBoard(files[0], ranks[2])) {
            sq[counter++] = new Square(files[0], ranks[2]);
        }
        if (isInBoard(files[1], ranks[0])) {
            sq[counter++] = new Square(files[1], ranks[0]);
        }
        if (isInBoard(files[1], ranks[3])) {
            sq[counter++] = new Square(files[1], ranks[3]);
        }
        if (isInBoard(files[2], ranks[0])) {
            sq[counter++] = new Square(files[2], ranks[0]);
        }
        if (isInBoard(files[2], ranks[3])) {
            sq[counter++] = new Square(files[2], ranks[3]);
        }
        if (isInBoard(files[3], ranks[1])) {
            sq[counter++] = new Square(files[3], ranks[1]);
        }
        if (isInBoard(files[3], ranks[2])) {
            sq[counter++] = new Square(files[3], ranks[2]);
        }

        Square[] full = new Square[counter];
        for (int i = 0; i < counter; i++) {
            full[i] = sq[i];
        }

        return full;
    }
}
