import java.util.Optional;

/**
 * Represents half of a move
 * @author zpanzarino3
 * @version 1.0.0
 */
public class Ply {
    private Piece piece;
    private Square from;
    private Square to;
    private Optional<String> comment;

    /**
     * Creates a new Ply
     * @param piece piece used in move
     * @param from square moving from
     * @param to square moving to
     * @param comment comment about the move
     */
    public Ply(Piece piece, Square from, Square to, Optional<String> comment) {
        this.piece = piece;
        this.from = from;
        this.to = to;
        this.comment = comment;
    }

    /**
     * Gets the Piece
     * @return piece
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * Gets the from Square
     * @return from Square
     */
    public Square getFrom() {
        return from;
    }

    /**
     * Gets the to Square
     * @return to Square
     */
    public Square getTo() {
        return to;
    }

    /**
     * Gets the comment
     * @return comment
     */
    public Optional<String> getComment() {
        return comment;
    }
}
