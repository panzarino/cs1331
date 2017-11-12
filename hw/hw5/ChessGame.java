import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ChessGame {
    private List<Move> moves;

    public ChessGame(List<Move> moves) {
        this.moves = moves;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public Move getMove(int index) {
        return moves.get(index);
    }

    public List<Move> filter(Predicate<Move> filter) {
        List<Move> output = new ArrayList<Move>();
        for (Move move : moves) {
            if (filter.test(move)) {
                output.add(move);
            }
        }
        return output;
    }

    public List<Move> getMovesWithComment() {
        return filter((Move move) -> {
            return move.getWhitePly().getComment().isPresent()
                || move.getBlackPly().getComment().isPresent();
        });
    }

    public List<Move> getMovesWithoutComment() {
        return filter(new Predicate<Move>() {
            public boolean test(Move move) {
                return !move.getWhitePly().getComment().isPresent()
                    && !move.getBlackPly().getComment().isPresent();
            }
        });
    }

    public List<Move> getMovesWithPiece(Piece piece) {
        return filter(new FilterPieces(piece));
    }

    public class FilterPieces implements Predicate<Move> {
        private Piece piece;

        public FilterPieces(Piece piece) {
            this.piece = piece;
        }

        public boolean test(Move move) {
            return move.getWhitePly().getPiece().getClass() == piece.getClass()
                || move.getBlackPly().getPiece().getClass() == piece.getClass();
        }
    }
}
