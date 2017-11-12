import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ChessGame {
    private List<Move> moves;

    public ChessGame(List<Move> moves) {
        this.moves = moves;
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
}
