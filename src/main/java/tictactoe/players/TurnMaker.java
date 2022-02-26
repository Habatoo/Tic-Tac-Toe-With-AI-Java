package tictactoe.players;

/**
 * Class for choosing current player object
 */
public class TurnMaker {
    private MakeTurnMethod method;

    /**
     * Method set object of current player inherit of {@link MakeTurnMethod}
     * @param method current player
     */
    public void setMethod(MakeTurnMethod method) {
        this.method = method;
    }

    /**
     * Method for make current turn for player
     */
    public void makeTurn() {
        this.method.makeTurn();
    }
}
