import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Arrays;

/**
 * Read a chess game formatted in PGN notation
 *
 * @see http://cs1331.gatech.edu/fall2017/hw1/hw1-pgn-reader.html
 *
 * @author Zach Panzarino <zachary@panzarino.com>
 */
public class PgnReader {

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
        return game.substring(startPos + 1, endPos).trim();
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
        char[][] board = new char[8][8];
        // uppercase will represent white
        // lowercase will represent black

        // populate pawns
        for (int i = 0; i < 8; i++) {
            board[1][i] = 'p';
            board[6][i] = 'P';
        }

        // add other pieces
        // rooks
        board[0][0] = board[0][7] = 'r';
        board[7][0] = board[7][7] = 'R';
        // knights
        board[0][1] = board[0][6] = 'n';
        board[7][1] = board[7][6] = 'N';
        // bishops
        board[0][2] = board[0][5] = 'b';
        board[7][2] = board[7][5] = 'B';
        // queens
        board[0][3] = 'q';
        board[7][3] = 'Q';
        // kings
        board[0][4] = 'k';
        board[7][4] = 'K';

        System.out.println(Arrays.deepToString(board));

        // begin tracking moves and updating board
        int move = 1;
        int movePos;
        // stores turn
        // true represents white
        // false represents black
        boolean active = true;
        while ((movePos = game.indexOf(move + ".")) != -1) {

            move++;
        }
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
