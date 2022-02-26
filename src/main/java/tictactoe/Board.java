package tictactoe;

/**
 * Class for working with game Board.
 * Draw initial board and the board with current situation.
 */
public class Board {
    public static Character[][] ticTacToeGrid;
    static int zero = 0;
    static int size = 3;

    static int numberX = zero;
    static int numberO = zero;
    static int numberSpace = zero;

    /**
     * Method for draw the Board with current game situation.
     */
    protected static void printBoard() {
        System.out.println("---------");
        for (Character[] array : ticTacToeGrid) {
            System.out.print("| ");
            for (Character play : array) {
                System.out.printf("%s ", play);
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }

    /**
     * Method for init empty game Board
     */
    protected static void initializeTicTacToeGrid() {
        ticTacToeGrid = new Character[][]{
                {'_', '_', '_'},
                {'_', '_', '_'},
                {'_', '_', '_'}
        };
    }
}
