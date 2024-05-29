

package rpgStateMachinePack;

public  abstract class RpgGameState {

    private final GameState state;

    public RpgGameState(GameState state)
    {
        this.state = state;
    }

    public GameState getState() {
        return this.state;
    }

    public abstract void update();
}
