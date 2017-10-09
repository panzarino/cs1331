public class Rook extends Piece {

    public Rook(Color color) {
        super(color);
    }

    @Override
    public String algebraicName() {
        return "R";
    }

    @Override
    public String fenName() {
        return (getColor() == Color.WHITE) ? "R" : "r";
    }

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
