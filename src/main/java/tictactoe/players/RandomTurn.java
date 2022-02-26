package tictactoe.players;

import java.util.Random;
import static tictactoe.Board.ticTacToeGrid;

/**
 * Class for generate random coordinates
 */
public class RandomTurn {

    static Random generator = new Random();

    /**
     * Method generate random coordinate from 0 to 2.
     * @return int[] with 0 for x coordinate and 1 for y coordinate
     */
    public static int[] generate() {
        int[] result = new int[2];
        int[] array = new int[]{0, 1, 2};
        while (true) {
            int randomX = generator.nextInt(array.length);
            int randomY = generator.nextInt(array.length);
            int x = array[randomX];
            int y = array[randomY];
            if (ticTacToeGrid[x][y] != '_') {
                continue;
            } else {
                result[0] = x;
                result[1] = y;
                return result;
            }
        }
    }
}
