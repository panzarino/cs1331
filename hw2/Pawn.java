public class Pawn extends Piece {

    public Pawn(Color color) {
        super(color);
    }

    @Override
    public String algebraicName() {
        return "";
    }

    @Override
    public String fenName() {
        return (getColor() == Color.WHITE) ? "P" : "p";
    }

    @Override
    public Square[] movesFrom(Square square) {
        if (getColor() == Color.WHITE) {
            Square one = new Square(square.getFile(), (char) (square.getRank() + 1));
            if (square.getRank() == '2') {
                Square two = new Square(square.getFile(), (char) (square.getRank() + 2));
                return new Square[]{one, two};
            }
            return new Square[]{one};
        } else {
            Square one = new Square(square.getFile(), (char) (square.getRank() - 1));
            if (square.getRank() == '7') {
                Square two = new Square(square.getFile(), (char) (square.getRank() - 2));
                return new Square[]{one, two};
            }
            return new Square[]{one};
        }
    }
}
