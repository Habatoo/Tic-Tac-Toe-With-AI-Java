package tictactoe.players;

import static tictactoe.Board.*;

/**
 * Class AI easy player
 * generate all data with coordinates for game randomly
 */
public class AIEasy implements MakeTurnMethod {
    char sign;

    public AIEasy(char sign) {
        this.sign = sign;
    }

    /**
     * Method for play game as an AI with easy strategy.
     * Randomly generate game coordinate during 0, 1 or 2.
     */
    @Override
    public void makeTurn() {
        System.out.println("Making move level \"easy\"");
        int[] array = RandomTurn.generate();
        ticTacToeGrid[array[0]][array[1]] = sign;
    }
}