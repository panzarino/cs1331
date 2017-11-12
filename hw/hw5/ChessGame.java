import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Represents a chess game
 * @author zpanzarino3
 * @version 1.0.0
 */
public class ChessGame {
    private List<Move> moves;

    /**
     * Creates a new chess game
     * @param moves list of moves
     */
    public ChessGame(List<Move> moves) {
        this.moves = moves;
    }

    /**
     * Gets moves in game
     * @return moves
     */
    public List<Move> getMoves() {
        return moves;
    }

    /**
     * Get a single move
     * @param index index of move
     * @return move at specified index
     */
    public Move getMove(int index) {
        return moves.get(index);
    }

    /**
     * Filters the list of moves
     * @param filter filter for the moves
     * @return filtered list of moves
     */
    public List<Move> filter(Predicate<Move> filter) {
        List<Move> output = new ArrayList<Move>();
        for (Move move : moves) {
            if (filter.test(move)) {
                output.add(move);
            }
        }
        return output;
    }

    /**
     * Gets moves with a comment
     * @return list of moves with comment
     */
    public List<Move> getMovesWithComment() {
        return filter((Move move) -> {
                return move.getWhitePly().getComment().isPresent()
                    || move.getBlackPly().getComment().isPresent();
            }
        );
    }

    /**
     * Gets moves without comment
     * @return list of moves without comment
     */
    public List<Move> getMovesWithoutComment() {
        return filter(new Predicate<Move>() {
            public boolean test(Move move) {
                return !move.getWhitePly().getComment().isPresent()
                    && !move.getBlackPly().getComment().isPresent();
            }
        });
    }

    /**
     * Gets moves with specified type of piece
     * @param piece piece to check for
     * @return list of moves with piece
     */
    public List<Move> getMovesWithPiece(Piece piece) {
        return filter(new FilterPieces(piece));
    }

    /**
     * Filter for moves based on type of pieces
     */
    public class FilterPieces implements Predicate<Move> {
        private Piece piece;

        /**
         * Creates a new piece filter
         * @param piece piece to be filtered for
         */
        public FilterPieces(Piece piece) {
            this.piece = piece;
        }

        /**
         * Tests if the given move fits the filter
         * @param move move to be checked
         * @return whether move fits filter
         */
        public boolean test(Move move) {
            return move.getWhitePly().getPiece().getClass() == piece.getClass()
                || move.getBlackPly().getPiece().getClass() == piece.getClass();
        }
    }
}
