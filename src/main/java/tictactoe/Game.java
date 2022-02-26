package tictactoe;

import static tictactoe.Board.*;

/**
 * Class for current game methods for check win condition and
 * choose current strategy with connections AI level.
 */
public class Game {

    /**
     * Method check win condition and result after current turn.
     * @param status String parameter for checking
     * @return true if game is end
     */
    public static boolean isEnd(String status) {
        boolean exit = false;
        boolean draw = status.equals("Draw");
        boolean xWins = status.equals("X wins");
        boolean oWins = status.equals("O wins");
        if (draw || xWins || oWins) {
            exit = true;
        }
        return exit;
    }

    /**
     * Method calculate numbers of 'X', 'O' and numbers of '_'
     * and check if one of gamer win the game
     * @return String with result "X wins" if gamer X win
     *                            "O wins" if gamer O win
     *                            "Draw" if no gamer win
     *                            "Game not finished" if game is not ended
     */
    public static String checkStatus() {
        String result = "";
        numberX = 0;
        numberO = 0;
        numberSpace = 0;
        for (int i = zero; i < size; i++) {
            for (int j = zero; j < size; j++) {
                if (ticTacToeGrid[i][j] == 'X') {
                    numberX++;
                }
                if (ticTacToeGrid[i][j] == 'O') {
                    numberO++;
                }
                if (ticTacToeGrid[i][j] == '_') {
                    numberSpace++;
                }
            }
        }

        if (checkStatus('X')) {
            System.out.println("X wins");
            result = "X wins";
        } else if (checkStatus('O')) {
            System.out.println("O wins");
            result = "O wins";
        } else if (numberSpace == zero) {
            System.out.println("Draw");
            result = "Draw";
        } else if (numberSpace > zero) {
            result = "Game not finished";
        }
        return result;
    }

    /**
     * Method check current position for char in parameters for win situation on the board
     * @param ch char for checking
     * @return true for win situation
     */
    private static boolean checkStatus(char ch) {
        boolean row0 = ticTacToeGrid[0][0] == ch && ticTacToeGrid[0][1] == ch && ticTacToeGrid[0][2] == ch;
        boolean row1 = ticTacToeGrid[1][0] == ch && ticTacToeGrid[1][1] == ch && ticTacToeGrid[1][2] == ch;
        boolean row2 = ticTacToeGrid[2][0] == ch && ticTacToeGrid[2][1] == ch && ticTacToeGrid[2][2] == ch;

        boolean col0 = ticTacToeGrid[0][0] == ch && ticTacToeGrid[1][0] == ch && ticTacToeGrid[2][0] == ch;
        boolean col1 = ticTacToeGrid[0][1] == ch && ticTacToeGrid[1][1] == ch && ticTacToeGrid[2][1] == ch;
        boolean col2 = ticTacToeGrid[0][2] == ch && ticTacToeGrid[1][2] == ch && ticTacToeGrid[2][2] == ch;

        boolean left = ticTacToeGrid[0][0] == ch && ticTacToeGrid[1][1] == ch && ticTacToeGrid[2][2] == ch;
        boolean right = ticTacToeGrid[0][2] == ch && ticTacToeGrid[1][1] == ch && ticTacToeGrid[2][0] == ch;

        return row0 || row1 || row2 || col0 || col1 || col2 || left || right;
    }

    /**
     * Method check current position for char in parameters and choose the turn for win
     * @param ch char for checking
     * @return String with coordinates for current turn or '--' if no win turn for current player
     */
    public static String canWin(char ch) {
        if (ticTacToeGrid[0][0] == ch && ticTacToeGrid[0][1] == ch && ticTacToeGrid[0][2] == '_') return "02";
        if (ticTacToeGrid[1][0] == ch && ticTacToeGrid[1][1] == ch && ticTacToeGrid[1][2] == '_') return "12";
        if (ticTacToeGrid[2][0] == ch && ticTacToeGrid[2][1] == ch && ticTacToeGrid[2][2] == '_') return "22";

        if (ticTacToeGrid[0][0] == ch && ticTacToeGrid[0][1] == '_' && ticTacToeGrid[0][2] == ch) return "01";
        if (ticTacToeGrid[1][0] == ch && ticTacToeGrid[1][1] == '_' && ticTacToeGrid[1][2] == ch) return "11";
        if (ticTacToeGrid[2][0] == ch && ticTacToeGrid[2][1] == '_' && ticTacToeGrid[2][2] == ch) return "21";

        if (ticTacToeGrid[0][0] == '_' && ticTacToeGrid[0][1] == ch && ticTacToeGrid[0][2] == ch) return "00";
        if (ticTacToeGrid[1][0] == '_' && ticTacToeGrid[1][1] == ch && ticTacToeGrid[1][2] == ch) return "10";
        if (ticTacToeGrid[2][0] == '_' && ticTacToeGrid[2][1] == ch && ticTacToeGrid[2][2] == ch) return "20";

        if (ticTacToeGrid[0][0] == ch && ticTacToeGrid[1][0] == ch && ticTacToeGrid[2][0] == '_') return "20";
        if (ticTacToeGrid[0][1] == ch && ticTacToeGrid[1][1] == ch && ticTacToeGrid[2][1] == '_') return "21";
        if (ticTacToeGrid[0][2] == ch && ticTacToeGrid[1][2] == ch && ticTacToeGrid[2][2] == '_') return "22";

        if (ticTacToeGrid[0][0] == ch && ticTacToeGrid[1][0] == '_' && ticTacToeGrid[2][0] == ch) return "10";
        if (ticTacToeGrid[0][1] == ch && ticTacToeGrid[1][1] == '_' && ticTacToeGrid[2][1] == ch) return "11";
        if (ticTacToeGrid[0][2] == ch && ticTacToeGrid[1][2] == '_' && ticTacToeGrid[2][2] == ch) return "12";

        if (ticTacToeGrid[0][0] == '_' && ticTacToeGrid[1][0] == ch && ticTacToeGrid[2][0] == ch) return "00";
        if (ticTacToeGrid[0][1] == '_' && ticTacToeGrid[1][1] == ch && ticTacToeGrid[2][1] == ch) return "01";
        if (ticTacToeGrid[0][2] == '_' && ticTacToeGrid[1][2] == ch && ticTacToeGrid[2][2] == ch) return "02";

        if (ticTacToeGrid[0][0] == ch && ticTacToeGrid[1][1] == ch && ticTacToeGrid[2][2] == '_') return "22";
        if (ticTacToeGrid[0][0] == ch && ticTacToeGrid[1][1] == '_' && ticTacToeGrid[2][2] == ch) return "11";
        if (ticTacToeGrid[0][0] == '_' && ticTacToeGrid[1][1] == ch && ticTacToeGrid[2][2] == ch) return "00";

        if (ticTacToeGrid[0][2] == ch && ticTacToeGrid[1][1] == ch && ticTacToeGrid[2][0] == '_') return "20";
        if (ticTacToeGrid[0][2] == ch && ticTacToeGrid[1][1] == '_' && ticTacToeGrid[2][0] == ch) return "11";
        if (ticTacToeGrid[0][2] == '_' && ticTacToeGrid[1][1] == ch && ticTacToeGrid[2][0] == ch) return "02";
        return "--";
    }

    /**
     * Method check current position for char in parameters and choose the turn for possible win
     * @param ch char for checking
     * @return String with coordinates for current turn
     */
    public static String hardWin(char ch) {
        if (ticTacToeGrid[1][0] == ch && ticTacToeGrid[0][1] == ch && ticTacToeGrid[0][0] == '_') return "00";
        if (ticTacToeGrid[1][0] == ch && ticTacToeGrid[2][1] == ch && ticTacToeGrid[2][0] == '_') return "20";
        if (ticTacToeGrid[1][2] == ch && ticTacToeGrid[0][1] == ch && ticTacToeGrid[0][2] == '_') return "02";
        if (ticTacToeGrid[1][2] == ch && ticTacToeGrid[2][1] == ch && ticTacToeGrid[2][2] == '_') return "22";

        if (ticTacToeGrid[1][0] == ch && ticTacToeGrid[0][1] == '_' && ticTacToeGrid[0][0] == '_') return "01";
        if (ticTacToeGrid[1][0] == ch && ticTacToeGrid[2][1] == '_' && ticTacToeGrid[2][0] == '_') return "21";
        if (ticTacToeGrid[0][1] == ch && ticTacToeGrid[1][0] == '_' && ticTacToeGrid[0][0] == '_') return "10";
        if (ticTacToeGrid[2][1] == ch && ticTacToeGrid[1][0] == '_' && ticTacToeGrid[2][0] == '_') return "10";
        if (ticTacToeGrid[1][2] == ch && ticTacToeGrid[0][1] == '_' && ticTacToeGrid[0][2] == '_') return "01";
        if (ticTacToeGrid[0][1] == ch && ticTacToeGrid[1][2] == '_' && ticTacToeGrid[0][2] == '_') return "12";
        if (ticTacToeGrid[1][2] == ch && ticTacToeGrid[2][1] == '_' && ticTacToeGrid[2][2] == '_') return "21";
        if (ticTacToeGrid[2][1] == ch && ticTacToeGrid[1][2] == '_' && ticTacToeGrid[2][2] == '_') return "12";

        if (ticTacToeGrid[1][0] == '_' && ticTacToeGrid[0][0] == '_' && ticTacToeGrid[0][0] == '_') return "10";
        if (ticTacToeGrid[0][1] == '_' && ticTacToeGrid[0][0] == '_' && ticTacToeGrid[0][0] == '_') return "01";
        if (ticTacToeGrid[1][2] == '_' && ticTacToeGrid[0][0] == '_' && ticTacToeGrid[0][0] == '_') return "12";
        if (ticTacToeGrid[2][1] == '_' && ticTacToeGrid[0][0] == '_' && ticTacToeGrid[0][0] == '_') return "21";
        return "--";
    }
}
