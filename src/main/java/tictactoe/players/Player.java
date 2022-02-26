package tictactoe.players;

import static tictactoe.Board.*;
import static tictactoe.Game.checkStatus;
import java.util.Scanner;

/**
 * Class Player for human's playing.
 * read data with coordinates for game form console
 */
public class Player implements MakeTurnMethod {
    static Scanner scanner = new Scanner(System.in);
    char sign;

    public Player(char sign) {
        this.sign = sign;
    }

    /**
     * Method for play game as a human.
     * Read coordinate from console, check them and make turn.
     */
    @Override
    public void makeTurn() {
        int x = -1;
        int y = -1;
        while (true) {
            System.out.print("Enter the coordinates: ");
            String[] words = scanner.nextLine().split(" ");
            if (words.length < 2) {
                System.out.println("You should enter numbers!");
                continue;
            } else {
                char xCh = words[0].charAt(0);
                char yCh = words[1].charAt(0);
                if (!Character.isDigit(xCh) || !Character.isDigit(yCh)) {
                    System.out.println("You should enter numbers!");
                    continue;
                } else {
                    x = Character.digit(xCh, 10) - 1;
                    y = Character.digit(yCh, 10) - 1;
                }
            }

            if (x < 0 || x > 2 || y < 0 || y > 2) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            } else if (ticTacToeGrid[x][y] != '_') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            } else {
                checkStatus();
                ticTacToeGrid[x][y] = sign;
                break;
            }
        }


    }
}