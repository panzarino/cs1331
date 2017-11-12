/**
 * Represents a Bishop
 * @author zpanzarino3
 * @version 1.0.0
 */
public class Bishop extends Piece {

    /**
     * Creates a new Bishop
     * @param c color of peice
     */
    public Bishop(Color c) {
        super(c);
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
        return getColor() == Color.WHITE ? "B" : "b";
    }

    /**
     * Determines possible move locations given starting position
     * @param square Starting positon
     * @return array of possible moves
     */
    @Override
    public Square[] movesFrom(Square square) {
        Square[] sq = new Square[27];
        int counter = 0;
        char rank = square.getRank();
        char file = square.getFile();
        for (int i = 1; i <= 8; i++) {
            char[] ranks = new char[]{(char) (rank + i), (char) (rank - i)};
            char[] files = new char[]{(char) (file + i), (char) (file - i)};
            if (isInBoard(files[0], ranks[0])) {
                sq[counter++] = new Square(files[0], ranks[0]);
            }
            if (isInBoard(files[1], ranks[0])) {
                sq[counter++] = new Square(files[1], ranks[0]);
            }
            if (isInBoard(files[0], ranks[1])) {
                sq[counter++] = new Square(files[0], ranks[1]);
            }
            if (isInBoard(files[1], ranks[1])) {
                sq[counter++] = new Square(files[1], ranks[1]);
            }
        }

        Square[] full = new Square[counter];
        for (int i = 0; i < counter; i++) {
            full[i] = sq[i];
        }

        return full;
    }

}
