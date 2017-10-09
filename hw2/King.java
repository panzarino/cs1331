public class King extends Piece {

    public King(Color color) {
        super(color);
    }

    @Override
    public String algebraicName() {
        return "K";
    }

    @Override
    public String fenName() {
        return (getColor() == Color.WHITE) ? "K" : "k";
    }

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
