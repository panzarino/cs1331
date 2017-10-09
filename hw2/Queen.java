public class Queen extends Piece {

    public Queen(Color color) {
        super(color);
    }

    @Override
    public String algebraicName() {
        return "Q";
    }

    @Override
    public String fenName() {
        return (getColor() == Color.WHITE) ? "Q" : "q";
    }

    @Override
    public Square[] movesFrom(Square square) {
        Rook rook = new Rook(getColor());
        Bishop bishop = new Bishop(getColor());
        Square[] rookSquares = rook.movesFrom(square);
        Square[] bishopSquares = bishop.movesFrom(square);
        Square[] output = new Square[rookSquares.length + bishopSquares.length];
        for (int i = 0; i < rookSquares.length; i++) {
            output[i] = rookSquares[i];
        }
        for (int i = 0; i < bishopSquares.length; i++) {
            output[i + rookSquares.length] = bishopSquares[i];
        }
        return output;
    }
}
