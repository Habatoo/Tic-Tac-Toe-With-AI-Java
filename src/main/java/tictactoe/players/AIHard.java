package tictactoe.players;

import tictactoe.Main;
import static tictactoe.Board.ticTacToeGrid;
import static tictactoe.Game.canWin;
import static tictactoe.Game.hardWin;

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
        while (true) {
            String iAmWin = canWin(sign);
            String heCanWin = canWin(sign == Main.signX ? Main.signO : Main.signX);
            if ("--".equals(heCanWin) && "--".equals(iAmWin)) {
                String xy = hardWin(sign);
                if (!"--".equals(xy)) {
                    String[] xyArray = xy.split("(?!^)");
                    ticTacToeGrid[Integer.parseInt(xyArray[0])][Integer.parseInt(xyArray[1])] = sign;
                    break;
                } else {
                    int[] array = RandomTurn.generate();
                    ticTacToeGrid[array[0]][array[1]] = sign;
                    break;
                }
            } else if ("--".equals(heCanWin) && !"--".equals(iAmWin) ||
                    !"--".equals(heCanWin) && !"--".equals(iAmWin)) {
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
