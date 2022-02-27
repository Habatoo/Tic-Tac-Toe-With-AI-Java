package tictactoe.players;

import java.util.ArrayList;
import java.util.List;

import tictactoe.Main;
import static tictactoe.Board.ticTacToeGrid;

/**
 * Main class for minmax function logic.
 */
public class MinMax {

    /**
     * Method for make move
     * @param ticTacToeGrid game board object
     * @param mePlayer char for current player
     */
    public static void makeMove(char[][] ticTacToeGrid, char mePlayer) {
        int player = mePlayer == Main.signX ? 1 : 0;
        Move bestMove = minMax(ticTacToeGrid, player, player);
        ticTacToeGrid[bestMove.index[0]][bestMove.index[1]] = mePlayer;
    }

    /**
     *
     * @param board game board for checking
     * @param currentPlayer char current player
     * @param callingPlayer char enemy player
     * @return Map with score for recursion analysis or index as a result
     */
    public static Move minMax(char[][] board, int callingPlayer, int currentPlayer) {

        char enemySymbol = ' ';
        char callingSymbol = ' ';
        if (callingPlayer == 1) {
            callingSymbol = 'X';
            enemySymbol = 'O';
        } else if (callingPlayer == 2) {
            callingSymbol = 'O';
            enemySymbol = 'X';
        }

        char symbol = ' ';
        int enemyNumber = 0;
        if (currentPlayer == 1) {
            symbol = 'X';
            enemyNumber = 2;
        } else if (currentPlayer == 2) {
            symbol = 'O';
            enemyNumber = 1;
        }


        int[][] availableSpots = emptyIndexes(board);

        if (win(board, enemySymbol)) {
            return new Move(-10);
        } else if (win(board, callingSymbol)) {
            return new Move(10);
        } else if (!areThereEmptyIndexes(board)) {
            return new Move(0);
        }

        List<Move> moves = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (availableSpots[i][j] == 1) {
                    Move move = new Move();
                    move.index = new int[]{i, j};
                    board[i][j] = symbol;
                    Move result = minMax(board, callingPlayer, enemyNumber);
                    move.score = result.score;
                    board[i][j] = '_';
                    moves.add(move);
                }
            }
        }

        // when the moves loop has ended, choose the move with the highest score
        int bestMove = 0;

        if (currentPlayer == callingPlayer) {
            int bestScore = -10000;
            for (int i = 0; i < moves.size(); i++) {
                if (moves.get(i).score > bestScore) {
                    bestScore = moves.get(i).score;
                    bestMove = i;
                }
            }
        } else {
            int bestScore = 10000;
            for (int i = 0; i < moves.size(); i++) {
                if (moves.get(i).score < bestScore) {
                    bestScore = moves.get(i).score;
                    bestMove = i;
                }
            }
        }
        return moves.get(bestMove);
    }

    /**
     * Method check current position for char in parameters for win situation on the board
     * @param ch char for checking
     * @return true for win situation
     */
    private static boolean win(char[][] board, char ch) {
        return (board[0][0] == ch && board[0][1] == ch && board[0][2] == ch) ||
                (board[1][0] == ch && board[1][1] == ch && board[1][2] == ch) ||
                (board[2][0] == ch && board[2][1] == ch && board[2][2] == ch) ||
                (board[0][0] == ch && board[1][0] == ch && board[2][0] == ch) ||
                (board[0][1] == ch && board[1][1] == ch && board[2][1] == ch) ||
                (board[0][2] == ch && board[1][2] == ch && board[2][2] == ch) ||
                (board[0][0] == ch && board[1][1] == ch && board[2][2] == ch) ||
                (board[0][2] == ch && board[1][1] == ch && board[2][0] == ch);
    }

    private static int[][] emptyIndexes(char[][] board) {
        int[][] empties = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (ticTacToeGrid[i][j] == '_') {
                    empties[i][j] = 1;
                } else {
                    empties[i][j] = 0;
                }
            }
        }
        return empties;
    }

    private static boolean areThereEmptyIndexes(char[][] board) {
        boolean empties = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (ticTacToeGrid[i][j] == '_') {
                    empties = true;
                }
            }
        }
        return empties;
    }
}
