package tictactoe.players;

import tictactoe.Main;
import static tictactoe.Board.*;
import static tictactoe.Game.canWin;

/**
 * Class AI medium strategy player
 * generate part data with coordinates for game randomly
 * use simple win strategy
 */
public class AIMedium implements MakeTurnMethod {
    char sign;

    public AIMedium(char sign) {
        this.sign = sign;
    }

    /**
     * Method for play game as an AI with medium strategy.
     * Check if it could win with current turn,
     * if not randomly generate game coordinate during 0, 1 or 2.
     */
    @Override
    public void makeTurn() {
        System.out.println("Making move level \"medium\"");
        while (true) {
            String iAmWin = canWin(sign);
            String heCanWin = canWin(sign == Main.signX ? Main.signO : Main.signX);
            if ("--".equals(heCanWin) && "--".equals(iAmWin)) {
                int[] array = RandomTurn.generate();
                ticTacToeGrid[array[0]][array[1]] = sign;
                break;
            } else if ("--".equals(heCanWin) && !"--".equals(iAmWin) || !"--".equals(heCanWin) && !"--".equals(iAmWin)) {
                String[] xy = iAmWin.split("(?!^)");
                ticTacToeGrid[Integer.parseInt(xy[0])][Integer.parseInt(xy[1])] = sign;
                break;
            } else if (!"--".equals(heCanWin) && "--".equals(iAmWin)){
                String[] xy = heCanWin.split("(?!^)");
                ticTacToeGrid[Integer.parseInt(xy[0])][Integer.parseInt(xy[1])] = sign;
                break;
            }
        }
    }
}