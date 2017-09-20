import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        int tagPos = game.indexOf("[" + tagName);
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
    private static void print2DArray(int[][] array) {
        for (int[] row : array) {
            for (int col : row) {
                String s = (col < 0) ? ", " : ",  ";
                System.out.print(col + s);
            }
            System.out.println();
        }
    }

    /**
     * Print out a 1 dimensional array of Strings for testing
     *
     * @author Zach Panzarino <zachary@panzarino.com>
     */
    private static void print1DArray(String[] array) {
        for (String i : array) {
            System.out.println(i);
        }
    }

    /**
     * Print out a 1 dimensional array of ints for testing
     *
     * @author Zach Panzarino <zachary@panzarino.com>
     */
    private static void print1DArray(int[] array) {
        for (int i : array) {
            System.out.println(i);
        }
    }

    /**
     * Converts a row letter to the corresponding int
     *
     * @author Zach Panzarino <zachary@panzarino.com>
     * @param letter letter of row
     * @return number of row
     */
    public static int colFromLetter(String letter) {
        String letters = "abcdefgh";
        return letters.indexOf(letter);
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
        int movesStart = game.indexOf("\n1.");
        String movesString = game.substring(movesStart);
        // split into each set of moves
        String[] movePairs = movesString.split("\\d+[.]\\s*");
        // split into individual moves
        // movePairs contains a blank string as the first element
        // so we have to get rid of that
        String[] moves = new String[movePairs.length * 2 - 2];
        for (int i = 1; i < movePairs.length; i++) {
            String[] split = movePairs[i].split("\\s");
            moves[i * 2 - 2] = split[0];
            // check to make sure it is actually a pair
            if (split.length != 1) {
                moves[i * 2 - 1] = split[1];
            } else {
                // if not a pair reduce the size of the array by one
                // so that there is not a blank move at the end
                String[] newMoves = new String[moves.length - 1];
                for (int x = 0; x < moves.length - 1; x++) {
                    newMoves[x] = moves[x];
                }
                // reassign moves to be returned
                moves = newMoves;
            }
        }
        return moves;
    }

    /**
     * Finds the position of a peice that should move based on given ending
     *
     * @author Zach Panzarino <zachary@panzarino.com>
     * @param board board to find move in
     * @param endRow ending row position
     * @param endCol ending column position
     * @param stringPiece piece if one is specified
     * @param stringPawn row of pawn as letter if one is specified
     * @param turn true if white turn, false if black turn
     * @return array of starting position as [startRow, startCol]
     */
    public static int[] findStart(
        // had to break apart params because longer than 80 chars
        int[][] board,
        int endRow, int endCol,
        String stringPiece, String stringPawn,
        boolean turn
    ) {
        // lots of if statements with .length because
        // we haven't learned try/catch yet which would be far easier

        // working backwards from ending position to find starting position

        // determine what team the piece is from to check for
        int team = (turn) ? 1 : -1;

        // using if because if condition is satisfied it will return
        // so it is not more efficient to use if else
        // also if else will not allow queen to check for both
        // rook and bishop properties

        // go through pawns first
        if (stringPiece == null) {

            // first check if it is just one up/down
            int pawnRow = endRow + team;
            // make sure the index is actually in bounds
            if (pawnRow < board.length && pawnRow > 0) {
                if (board[pawnRow][endCol] == team * PAWN) {
                    return new int[]{pawnRow, endCol};
                }
            }
            // then check if it is two up/down from starting position
            pawnRow += team;
            if (pawnRow < board.length && pawnRow > 0) {
                if (board[pawnRow][endCol] == team * PAWN) {
                    // set starting row for pawns
                    int startRow = (turn) ? 6 : 1;
                    if (pawnRow == startRow) {
                        return new int[]{startRow, endCol};
                    }
                }
            }
            // check if there was a pawn capture
            if (stringPawn != null) {
                int pawnCol = colFromLetter(stringPawn);
                int pawnRow1 = endRow + team;
                if (pawnRow1 < board.length && pawnRow1 > 0) {
                    return new int[]{pawnRow1, pawnCol};
                }
            }
        }

        // go through the rooks (and queens)
        if (stringPiece.equals("R") || stringPiece.equals("Q")) {

            // check for up/down moves
            for (int i = 0; i < board.length; i++) {
                int val = board[i][endCol];
                if (val == team * ROOK || val == team * QUEEN) {
                    return new int[]{i, endCol};
                }
            }
            // check for left/right moves
            for (int i = 0; i < board[endRow].length; i++) {
                int val = board[i][endCol];
                if (val == team * ROOK || val == team * QUEEN) {
                    return new int[]{endRow, i};
                }
            }
        }

        // go through the bishops (and queens)
        if (stringPiece.equals("B") || stringPiece.equals("Q")) {

            // check down right
            for (int row = endRow, col = endCol;
                row < board.length && col < board[row].length;
                row++, col++
            ) {
                int val = board[row][col];
                if (val == team * BISHOP || val == team * QUEEN) {
                    return new int[]{row, col};
                }
            }
            // check down left
            for (int row = endRow, col = endCol;
                row < board.length && col >= 0;
                row++, col--
            ) {
                int val = board[row][col];
                if (val == team * BISHOP || val == team * QUEEN) {
                    return new int[]{row, col};
                }
            }
            // check up right
            for (int row = endRow, col = endCol;
                row >= 0 && col < board[row].length;
                row--, col++
            ) {
                int val = board[row][col];
                if (val == team * BISHOP || val == team * QUEEN) {
                    return new int[]{row, col};
                }
            }
            // check up left
            for (int row = endRow, col = endCol;
                row >= 0 && col >= 0;
                row--, col--
            ) {
                int val = board[row][col];
                if (val == team * BISHOP || val == team * QUEEN) {
                    return new int[]{row, col};
                }
            }
        }

        if (stringPiece.equals("N")) {

            // go through the knights
            // have to keep checking if the indexes are in bounds
            // because we can't use try/except

            // create a bunch of unnessessary variables
            // because its easier to check the indexes
            int twoUp = endRow - 2;
            int twoDown = endRow + 2;
            int oneUp = endRow - 1;
            int oneDown = endRow - 1;
            int twoRight = endCol + 2;
            int twoLeft = endCol - 2;
            int oneRight = endCol + 1;
            int oneLeft = endCol - 1;

            // don't use else if becuase it will not properly check all
            if (twoUp >= 0 && oneRight < board[twoUp].length) {
                if (board[twoUp][oneRight] == team * KNIGHT) {
                    return new int[]{twoUp, oneRight};
                }
            }
            if (twoUp >= 0 && oneLeft >= 0) {
                if (board[twoUp][oneLeft] == team * KNIGHT) {
                    return new int[]{twoUp, oneLeft};
                }
            }
            if (twoDown >= 0 && oneRight < board[twoDown].length) {
                if (board[twoDown][oneRight] == team * KNIGHT) {
                    return new int[]{twoDown, oneRight};
                }
            }
            if (twoDown >= 0 && oneLeft >= 0) {
                if (board[twoDown][oneLeft] == team * KNIGHT) {
                    return new int[]{twoDown, oneLeft};
                }
            }
            if (oneUp >= 0 && twoRight < board[oneUp].length) {
                if (board[oneUp][twoRight] == team * KNIGHT) {
                    return new int[]{oneUp, twoRight};
                }
            }
            if (oneUp >= 0 && twoLeft >= 0) {
                if (board[oneUp][twoLeft] == team * KNIGHT) {
                    return new int[]{oneUp, twoLeft};
                }
            }
            if (oneDown >= 0 && twoRight < board[oneDown].length) {
                if (board[oneDown][twoRight] == team * KNIGHT) {
                    return new int[]{oneDown, twoRight};
                }
            }
            if (oneDown >= 0 && twoLeft >= 0) {
                if (board[oneDown][twoLeft] == team * KNIGHT) {
                    return new int[]{oneDown, twoLeft};
                }
            }
        }

        if (stringPiece.equals("K")) {
            int up = endRow - 1;
            int down = endRow + 1;
            int left = endCol - 1;
            int right = endCol + 1;

            // lots of if statements to make sure
            // we don't get an index out of bounds error
            if (up >= 0) {
                if (board[up][endCol] == team * KING) {
                    return new int[]{up, endCol};
                }
                if (left >= 0) {
                    if (board[up][left] == team * KING) {
                        return new int[]{up, left};
                    }
                }
                if (right < board[up].length) {
                    if (board[up][right] == team * KING) {
                        return new int[]{up, right};
                    }
                }
            }
            if (down < board.length) {
                if (board[down][endCol] == team * KING) {
                    return new int[]{down, endCol};
                }
                if (left >= 0) {
                    if (board[down][left] == team * KING) {
                        return new int[]{down, left};
                    }
                }
                if (right < board[down].length) {
                    if (board[down][right] == team * KING) {
                        return new int[]{down, right};
                    }
                }
            }
            if (left >= 0) {
                if (board[endRow][left] == team * KING) {
                    return new int[]{endRow, left};
                }
            }
            if (right >= 0) {
                if (board[endRow][right] == team * KING) {
                    return new int[]{endRow, right};
                }
            }
        }

        // default return so the compiler doesn't throw an error
        return new int[]{0, 0};
    }

    /**
     * Parses a move and executes it
     *
     * Returned move instructions:
     * [
     * rowFrom
     * colFrom
     * rowTo
     * colTo
     * ]
     *
     * @author Zach Panzarino <zachary@panzarino.com>
     * @param board board for move to be found on
     * @param move string of the move
     * @param turn true if white turn, false if black turn
     * @return int array corresponding to certain move instructions
     */
    public static int[] parseMove(int[][] board, String move, boolean turn) {
        // create the regex pattern that splits apart the move
        Pattern regexPattern = Pattern.compile(
            // fairly complicated regex string that
            // breaks apart all of the move attributes

            // check if a piece is specified first
            "([RNBQK])?"
            // check if a pawn is specified
            // require that there is no number immediately afterwards
            // to distinguish between pawn and position
            + "([a-h](?!\\d))?"
            // check if there is a capture
            // not needed but gets it out of the way
            + "(x)?"
            // find the ending row
            // must be followed by number to distinguish between pawns
            + "([a-h](?=\\d))"
            // find the ending column
            + "(\\d)"
        );
        // use the regex to parse and break apart the string
        Matcher regexMatcher = regexPattern.matcher(move);
        regexMatcher.find();

        // assign variables to the different parts that were just extracted
        String stringPiece = regexMatcher.group(1);
        String stringPawn = regexMatcher.group(2);
        String stringCapture = regexMatcher.group(3);
        String stringColumn = regexMatcher.group(4);
        String stringRow = regexMatcher.group(5);

        // set the ending position in ints
        int finalRow = board.length - Integer.parseInt(stringRow);
        int finalCol = colFromLetter(stringColumn);

        // get the starting coordinates
        int[] startingPos = findStart(
            board, finalRow, finalCol, stringPiece, stringPawn, turn
        );

        // return the coordinates
        return new int[]{finalRow, finalCol, startingPos[0], startingPos[1]};
    }

    /**
     * Executes the move specified by int instructions
     *
     * Instructions are expected to come from parseMove method
     *
     * @author Zach Panzarino <zachary@panzarino.com>
     * @param board board for moves to be made on
     * @param moves moves to be made
     * @return updated board
     */
    public static int[][] executeMove(int[][] board, int[] moves) {
        // assumes that input is a valid move
        int toRow = moves[0];
        int toCol = moves[1];
        int fromRow = moves[2];
        int fromCol = moves[3];
        // move the piece
        board[toRow][toCol] = board[fromRow][fromCol];
        // remove the old location
        board[fromRow][fromCol] = 0;
        return board;
    }

    /**
     * Reverses the sign of ints in a board
     *
     * @author Zach Panzarino <zachary@panzarino.com>
     * @param board original board of game
     * @return reversed board
     */
    public static int[][] reverseBoard(int[][] board) {
        int[][] output = new int[board.length][board[0].length];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                output[r][c] = -board[r][c];
            }
        }
        return output;
    }

    /**
     * Converts a piece number into the respective character
     *
     * @author Zach Panzarino <zachary@panzarino.com>
     * @param number number of piece
     * @return character of piece
     */
    public static char convertPiece(int number) {
        char[] upper = new char[]{' ', 'P', 'R', 'N', 'B', 'Q', 'K'};
        char[] lower = new char[]{' ', 'p', 'r', 'n', 'b', 'q', 'k'};
        return (number > 0) ? lower[number] : upper[-number];
    }

    /**
     * Converts a board to FEN Notation
     *
     * @author Zach Panzarino <zachary@panzarino.com>
     * @param board board of the game
     * @param turn true for white turn, false for black turn
     * @return FEN representation of given board
     */
    public static String convertFEN(int[][] board, boolean turn) {
        // output to be added on to
        String output = "";
        // temp var to keep track of empty spaces
        int empty = 0;
        // reverse the board if its black turn
        board = (turn) ? board : reverseBoard(board);
        // loop through the board
        for (int[] row : board) {
            for (int col : row) {
                // check if there is a value for empty
                if (col == 0) {
                    empty++;
                }
                else {
                    if (empty > 0) {
                        output += empty;
                        empty = 0;
                    }
                    output += convertPiece(col);
                }
            }
            if (empty > 0) {
                output += empty;
                empty = 0;
            }
            output += '/';
        }
        return output;
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

        String[] moves = separateMoves(game);

        boolean turn = true;

        // execute each of the moves
        for (String move : moves) {
            // first check for castles because they will not follow standard
            // regex pattern for every other move
            // and they require two moves, where all others require one
            if (move.equals("O-O")) {
                if (turn) {
                    board = executeMove(board, new int[]{7, 4, 7, 6});
                    board = executeMove(board, new int[]{7, 7, 7, 5});
                } else {
                    board = executeMove(board, new int[]{0, 4, 0, 6});
                    board = executeMove(board, new int[]{0, 7, 0, 5});
                }
            } else if (move.equals("O-O-O")) {
                if (turn) {
                    board = executeMove(board, new int[]{7, 4, 7, 2});
                    board = executeMove(board, new int[]{7, 0, 7, 3});
                } else {
                    board = executeMove(board, new int[]{0, 4, 0, 2});
                    board = executeMove(board, new int[]{0, 0, 0, 3});
                }
            } else {
                int[] directions = parseMove(board, move, turn);
                board = executeMove(board, directions);
            }
            turn = !turn;
        }

        return convertFEN(board, turn);
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
