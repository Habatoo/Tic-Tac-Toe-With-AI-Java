package tictactoe.players;

import static tictactoe.Board.*;
import static tictactoe.players.MinMax.*;

/**
 * Class AI hard strategy player
 * generate all data with coordinates for game randomly
 */
public class AIHard implements MakeTurnMethod {
    char sign;

    public AIHard(char sign) {
        this.sign = sign;
    }

    /**
     * Method for play game as an AI with hard strategy.
     * Check if it could win with current turn,
     * if not make turn with preferable strategy
     */
    @Override
    public void makeTurn() {
        System.out.println("Making move level \"hard\"");
        makeMove(ticTacToeGrid, sign);
    }
}
