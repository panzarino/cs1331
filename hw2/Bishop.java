public class Bishop extends Piece {

    public Bishop(Color color) {
        super(color);
    }

    @Override
    public String algebraicName() {
        return "B";
    }

    @Override
    public String fenName() {
        return (getColor() == Color.WHITE) ? "B" : "b";
    }

    @Override
    public Square[] movesFrom(Square square) {
        Square[] output = new Square[15];
        int count = 0;
        int rank = square.getRank();
        int file = square.getFile();
        for (int row = rank, col = file;
            row <= '8' && col <= 'h';
            row++, col++) {
            output[count++] = new Square((char) col, (char) row);
        }
        for (int row = rank, col = file;
            row <= '8' && col >= 'a';
            row++, col--) {
            output[count++] = new Square((char) col, (char) row);
        }
        for (int row = rank, col = file;
            row >= '1' && col <= 'h';
            row--, col++) {
            output[count++] = new Square((char) col, (char) row);
        }
        for (int row = rank, col = file;
            row >= '1' && col >= 'a';
            row--, col--) {
            output[count++] = new Square((char) col, (char) row);
        }
        return cleanArray(output, square);
    }
}
