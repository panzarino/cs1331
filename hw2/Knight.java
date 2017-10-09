public class Knight extends Piece {

    public Knight(Color color) {
        super(color);
    }

    @Override
    public String algebraicName() {
        return "N";
    }

    @Override
    public String fenName() {
        return (getColor() == Color.WHITE) ? "N" : "n";
    }

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
