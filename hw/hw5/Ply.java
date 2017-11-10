import java.util.Optional;

public class Ply {
    private Piece piece;
    private Square from;
    private Square to;
    Optional<String> comment;

    public Ply(Piece piece, Square from, Square to, Optional<String> comment) {
        this.piece = piece;
        this.from = from;
        this.to = to;
        this.comment = comment;
    }

    public Piece getPiece() {
        return piece;
    }

    public Square getFrom() {
        return from;
    }

    public Square getTo() {
        return to;
    }

    public Optional<String> getComment() {
        return comment;
    }
}
