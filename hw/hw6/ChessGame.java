import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Chess game
 * @author zpanzarino3
 * @version 1.0.0
 */
public class ChessGame {

    private StringProperty event = new SimpleStringProperty(this, "NA");
    private StringProperty site = new SimpleStringProperty(this, "NA");
    private StringProperty date = new SimpleStringProperty(this, "NA");
    private StringProperty white = new SimpleStringProperty(this, "NA");
    private StringProperty black = new SimpleStringProperty(this, "NA");
    private StringProperty result = new SimpleStringProperty(this, "NA");
    private List<String> moves;

    /**
     * Create a new chess game
     * @param event Name of the event
     * @param site Name of the site
     * @param date Date of the game
     * @param white Name of white player
     * @param black Name of black player
     * @param result Result of game
     */
    public ChessGame(String event, String site, String date,
                     String white, String black, String result) {
        this.event.set(event);
        this.site.set(site);
        this.date.set(date);
        this.white.set(white);
        this.black.set(black);
        this.result.set(result);
        moves = new ArrayList<>();
    }

    /**
     * Add new move to game
     * @param move Move to be added
     */
    public void addMove(String move) {
        moves.add(move);
    }

    /**
     * Get move at given index
     * @param n Index of move
     * @return move at index
     */
    public String getMove(int n) {
        return moves.get(n);
    }

    /**
     * Get all moves in game
     * @return Moves in game
     */
    public List<String> getMoves() {
        return moves;
    }

    /**
     * Get event
     * @return Event
     */
    public String getEvent() {
        return event.get();
    }

    /**
     * Get site
     * @return Site
     */
    public String getSite() {
        return site.get();
    }

    /**
     * Get date
     * @return Date
     */
    public String getDate() {
        return date.get();
    }

    /**
     * Get white
     * @return White
     */
    public String getWhite() {
        return white.get();
    }

    /**
     * Get black
     * @return Black
     */
    public String getBlack() {
        return black.get();
    }

    /**
     * Get result
     * @return Result
     */
    public String getResult() {
        return result.get();
    }
}
