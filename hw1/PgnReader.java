import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Read a chess game formatted in PGN notation
 *
 * @see http://cs1331.gatech.edu/fall2017/hw1/hw1-pgn-reader.html
 *
 * @author Zach Panzarino <zachary@panzarino.com>
 */
public class PgnReader {

    // pieces that correspond to numbers
    // positive = white, negative = black
    // using ints makes it easier to do math
    public static final int EMPTY = 0;
    public static final int PAWN = 1;
    public static final int ROOK = 2;
    public static final int KNIGHT = 3;
    public static final int BISHOP = 4;
    public static final int QUEEN = 5;
    public static final int KING = 6;

    /**
     * Find the tagName tag pair in a PGN game and return its value.
     *
     * @see http://www.saremba.de/chessgml/standards/pgn/pgn-complete.htm
     *
     * @author Zach Panzarino <zachary@panzarino.com>
     * @param tagName name of the tag whose value you want
     * @param game PGN text of a chess game
     * @return value in the named tag pair
     */
    public static String tagValue(String tagName, String game) {
        int tagPos = game.indexOf(tagName);
        if (tagPos == -1) {
            return "NOT GIVEN";
        }
        int startPos = game.indexOf('"', tagPos);
        int endPos = game.indexOf('"', startPos + 1);
        return game.substring(startPos + 1, endPos);
    }

    /**
     * Print out the board for testing
     *
     * @author Zach Panzarino <zachary@panzarino.com>
     */
    private static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int col : row) {
                System.out.print(col + ", ");
            }
            System.out.println();
        }
    }

    /**
     * Populate the board with starting positions for pieces
     *
     * @author Zach Panzarino <zachary@panzarino.com>
     * @return starting board
     */
    public static int[][] populate() {
        int[][] board = new int[8][8];

        // populate pawns
        for (int i = 0; i < board.length; i++) {
            board[1][i] = -PAWN;
            board[6][i] = PAWN;
        }

        // add other pieces
        // rooks
        board[0][0] = -ROOK;
        board[0][7] = -ROOK;
        board[7][0] = ROOK;
        board[7][7] = ROOK;
        // knights
        board[0][1] = -KNIGHT;
        board[0][6] = -KNIGHT;
        board[7][1] = KNIGHT;
        board[7][6] = KNIGHT;
        // bishops
        board[0][2] = -BISHOP;
        board[0][5] = -BISHOP;
        board[7][2] = BISHOP;
        board[7][5] = BISHOP;
        // queens
        board[0][3] = -QUEEN;
        board[7][3] = QUEEN;
        // kings
        board[0][4] = -KING;
        board[7][4] = KING;

        return board;
    }

    /**
     * Splits apart moves from game String
     *
     * @author Zach Panzarino <zachary@panzarino.com>
     * @param game String of game input
     * @return list of separated moves
     */
    public static String[] separateMoves(String game) {
        return null;
    }

    /**
     * Parses a move and executes it
     *
     * @author Zach Panzarino <zachary@panzarino.com>
     * @param board game board to be used
     * @param move string of the move
     * @param turn true if white turn, false if black turn
     * @return int array corresponding to certain move instructions
     */
    public static int[] parseMove(int[][] board, String move, boolean turn) {
        return null;
    }

    /**
     * Play out the moves in game and return a String with the game's
     * final position in Forsyth-Edwards Notation (FEN).
     *
     * @see http://www.saremba.de/chessgml/standards/pgn/pgn-complete.htm#c16.1
     *
     * @author Zach Panzarino <zachary@panzarino.com>
     * @param game PGN-formatted chess game or opening
     * @return game final position in FEN
     */
    public static String finalPosition(String game) {

        int[][] board = populate();

        return "";
    }

    /**
     * Reads the file named by path and returns its content as a String.
     *
     * @author Zach Panzarino <zachary@panzarino.com>
     * @param path relative or abolute path of the file to read
     * @return content of the file
     */
    public static String fileContent(String path) {
        Path file = Paths.get(path);
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
            System.exit(1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String game = fileContent(args[0]);
        System.out.format("Event: %s%n", tagValue("Event", game));
        System.out.format("Site: %s%n", tagValue("Site", game));
        System.out.format("Date: %s%n", tagValue("Date", game));
        System.out.format("Round: %s%n", tagValue("Round", game));
        System.out.format("White: %s%n", tagValue("White", game));
        System.out.format("Black: %s%n", tagValue("Black", game));
        System.out.format("Result: %s%n", tagValue("Result", game));
        System.out.println("Final Position:");
        System.out.println(finalPosition(game));

    }
}
