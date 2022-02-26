package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

import static tictactoe.Board.*;
import static tictactoe.Game.*;
import tictactoe.players.*;

/**
 * Mail logic of game with all methods of init new game,
 * make turn and check win conditions.
 */
public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static boolean xTurn;
    public static char signX = 'X';
    public static char signO = 'O';
    public static MakeTurnMethod player_1;
    public static MakeTurnMethod player_2;

    /**
     * Start point of game. Init game board and game difficulty.
     * @param args input args of init command: first param: start for start game,
     *             exit for ending
     */
    public static void main(String[] args) {
        TurnMaker turnMaker = new TurnMaker();
        xTurn = true;
        outer: while (true) {
            boolean exit = startGame(turnMaker);
            if (!exit) {
                initializeTicTacToeGrid();
                printBoard();
                while (true) {
                    getTurn();
                    printBoard();
                    String status = checkStatus();
                    if (isEnd(status)) {
                        break outer;
                    }
                }
            }
            break;
        }
    }

    /**
     * Methods start game. Check input args status. Init games with user - man player,
     * easy, medium and hard - AI players.
     * @param turnMaker class for init player with new object {@link TurnMaker}
     * @return true for continue game, false for exit game.
     */
    private static boolean startGame(TurnMaker turnMaker) {
        boolean exit = true;
        while (exit) {
            System.out.print("Input command: ");
            String[] line = scanner.nextLine().split(" ");
            if (line.length == 0) {
                System.out.println("Bad parameters!");
                continue;
            } else if ("exit".equals(line[0])) {
                break;
            } else if ("start".equals(line[0]) && line.length >= 3) {
                String[] values = {"easy","user","medium","hard"};
                if (Arrays.stream(values).anyMatch(line[1]::equals) &&
                        Arrays.stream(values).anyMatch(line[2]::equals)) {
                    switch (line[1]) {
                        case "easy":
                            player_1 = new AIEasy(signX);
                            initGame(turnMaker, player_1);
                            break;
                        case "user":
                            player_1 = new Player(signX);
                            initGame(turnMaker, player_1);
                            break;
                        case "medium":
                            player_1 = new AIMedium(signX);
                            initGame(turnMaker, player_1);
                            break;
                        case "hard":
                            player_1 = new AIHard(signX);
                            initGame(turnMaker, player_1);
                            break;
                    }
                    switch (line[2]) {
                        case "easy":
                            player_2 = new AIEasy(signO);
                            initGame(turnMaker, player_2);
                            break;
                        case "user":
                            player_2 = new Player(signO);
                            initGame(turnMaker, player_2);
                            break;
                        case "medium":
                            player_2 = new AIMedium(signO);
                            initGame(turnMaker, player_2);
                            break;
                        case "hard":
                            player_2 = new AIHard(signO);
                            initGame(turnMaker, player_2);
                            break;
                    }
                    exit = false;
                }
            } else {
                System.out.println("Bad parameters!");
                continue;
            }
        }
        return exit;
    }

    /**
     *
     * @param turnMaker player as object {@link TurnMaker}
     * @param makeTurnMethod object type interface MakeTurnMethod (player)
     */
    private static void initGame(TurnMaker turnMaker, MakeTurnMethod makeTurnMethod) {
        turnMaker.setMethod(makeTurnMethod);
    }

    /**
     * Method for choosing current turn.
     * Checks var xTurn, that is true if gamer with 'X' turn
     * or if false if gamer with 'O' turn.
     */
    private static void getTurn() {
        checkStatus();
        if (xTurn) {
            player_1.makeTurn();
            xTurn = false;
        } else {
            player_2.makeTurn();
            xTurn = true;
        }
    }
}