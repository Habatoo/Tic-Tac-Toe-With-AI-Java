package tictactoe.players;

import tictactoe.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static tictactoe.Board.*;

public class MinMax {
    public static char[] origBoard = new char[9];
    public static List<Integer> availSpots = new ArrayList<>();

    /**
     * Method create game board in linear view.
     */
    private static void actualLineBoard() {
        origBoard[0] = ticTacToeGrid[0][0];
        origBoard[1] = ticTacToeGrid[0][1];
        origBoard[2] = ticTacToeGrid[0][2];
        origBoard[3] = ticTacToeGrid[1][0];
        origBoard[4] = ticTacToeGrid[1][1];
        origBoard[5] = ticTacToeGrid[1][2];
        origBoard[6] = ticTacToeGrid[2][0];
        origBoard[7] = ticTacToeGrid[2][1];
        origBoard[8] = ticTacToeGrid[2][2];
    }

    /**
     * Method collect index of empty places
     * update save in available
     */
    private static void emptyIndexies() {
        for (int i = 0; i <  origBoard.length; i++) {
            if (origBoard[i] == '_') {
                availSpots.add(i);
            }
        }
    }

    // human
    static char huPlayer = 'O';
    // ai
    static char aiPlayer = 'X';

    // finding the ultimate play on the game that favors the computer
    Map<String, Integer> bestSpot = minMax(origBoard, aiPlayer);

    // the main minimax function
    public static Map<String, Integer> minMax(char[] origBoard, char player) {
        char[] newBoard = origBoard.clone();
        Map<String, Integer> score = new HashMap<>();
        if (win(newBoard, huPlayer)) {
            score.put("score", -10);
            return score;
        } else if (win(newBoard, aiPlayer)) {
            score.put("score", 10);
            return score;
        } else if (availSpots.size() == 0){
            score.put("score", 0);
            return score;
        }

        // an array to collect all the objects
        List<Map<String, Integer>> moves = new ArrayList<>();

        // loop through available spots
        for (var i = 0; i < availSpots.size(); i++) {
            //create an object for each and store the index of that spot that was stored
            // as a number in the object's index key
            Map<String, Integer> move = new HashMap();
            move.put("index", availSpots.get(i));

            newBoard[availSpots.get(i)] = player; // set the empty spot to the current player

            //if collect the score resulted from calling minimax on the opponent of the current player
            if (player == aiPlayer){
                var result = minMax(newBoard, huPlayer);
                move.put("score", result.get("score"));
            } else{
                var result = minMax(newBoard, aiPlayer);
                move.put("score", result.get("score"));
            }

            newBoard[availSpots.get(i)] = '_'; //reset the spot to empty
            moves.add(move); // push the object to the array
        }

        // if it is the computer's turn loop over the moves
        // and choose the move with the highest score
        int bestMove;
        if (player == aiPlayer) {
            var bestScore = -10000;
            for (var i = 0; i < moves.size(); i++) {
                if (moves.get(i).get("score") > bestScore) {
                    bestScore = moves.get(i).get("score");
                    bestMove = i;
                }
            }
        } else {
            // else loop over the moves and choose the move with the lowest score
            var bestScore = 10000;
            for (var i = 0; i < moves.size(); i++) {
                if (moves.get(i).get("score") < bestScore){
                    bestScore = moves.get(i).get("score");
                    bestMove = i;
                }
            }
        }

        // return the chosen move (object) from the array to the higher depth
        return moves.get(bestMove);
    }

    /**
     * Method check current position for char in parameters for win situation on the board
     * @param ch char for checking
     * @return true for win situation
     */
    private static boolean win(char[] board, char ch) {
        boolean row0 = board[0] == ch && board[1] == ch && board[2] == ch;
        boolean row1 = board[3] == ch && board[4] == ch && board[5] == ch;
        boolean row2 = board[6] == ch && board[7] == ch && board[8] == ch;
        boolean col0 = board[0] == ch && board[3] == ch && board[6] == ch;
        boolean col1 = board[1] == ch && board[4] == ch && board[7] == ch;
        boolean col2 = board[2] == ch && board[5] == ch && board[8] == ch;
        boolean left = board[0] == ch && board[4] == ch && board[8] == ch;
        boolean right = board[2] == ch && board[4] == ch && board[6] == ch;
        return row0 || row1 || row2 || col0 || col1 || col2 || left || right;
    }
}
