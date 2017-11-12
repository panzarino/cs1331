/**
 * Represents a move
 * @author zpanzarino3
 * @version 1.0.0
 */
public class Move {
    private Ply whitePly;
    private Ply blackPly;

    /**
     * Creates a new Move
     * @param whitePly white Ply
     * @param blackPly black Ply
     */
    public Move(Ply whitePly, Ply blackPly) {
        this.whitePly = whitePly;
        this.blackPly = blackPly;
    }

    /**
     * Get white Ply
     * @return white Ply
     */
    public Ply getWhitePly() {
        return whitePly;
    }

    /**
     * Get black Ply
     * @return black Ply
     */
    public Ply getBlackPly() {
        return blackPly;
    }
}
