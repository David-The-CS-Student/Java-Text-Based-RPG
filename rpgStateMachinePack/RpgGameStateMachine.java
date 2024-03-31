
package rpgStateMachinePack;
import adminPack.RpgAdminStateMachine;
import generics.Array;
import mainApp.RpgGame;
import saveFolder.Save;

enum GameState{

    DestinyTown,

    Plains1,

    SkaburnVillage,

    Quit
}

public class RpgGameStateMachine {

    private static RpgGameStateMachine mainInstance = null;

    private GameState currentState;

    public Array<RpgGameState> rpgGameStates;


    public RpgGameStateMachine(){

        rpgGameStates = new Array<>(1);

        rpgGameStates.add(new DestinyTownState());

    }


    public static RpgGameStateMachine getMainInstance(){
        if(mainInstance ==  null){

            mainInstance = new RpgGameStateMachine();
            return mainInstance;
        }

        return mainInstance;
    }

    private RpgGameState getRpgGameState(GameState gameState){
        for(int stateIndex = 0; stateIndex < rpgGameStates.getCount(); stateIndex++){
            if(rpgGameStates.getObject(stateIndex).getState() == gameState ){
                return rpgGameStates.getObject(stateIndex);
            }

        }
        return null;
    }

    public GameState getRpgGameState(String stateName){
        for(int stateIndex = 0; stateIndex < rpgGameStates.getCount(); stateIndex++){
            if(rpgGameStates.getObject(stateIndex).getState().name().equals(stateName)){
                return rpgGameStates.getObject(stateIndex).getState();
            }
        }
        return null;
    }

    public GameState getCurrentState() {
        return currentState;
    }

    public String getCurrentStateString(){return this.currentState.name();}
    public void setState(GameState newState){
        this.currentState = newState;
    }

    public void setState(String newState){

        for(int stateIndex = 0; stateIndex < rpgGameStates.getCount(); stateIndex++){
            if(rpgGameStates.getObject(stateIndex).getState().name().equals(newState)){

                this.currentState = rpgGameStates.getObject(stateIndex).getState();
            }
        }

        if(newState.equals(GameState.Quit.name()))
        {
            this.currentState = GameState.Quit;
        }
    }

    public void update(){

        gameLoop:
        while(true)
        {

            switch(this.currentState)
            {
                case DestinyTown:

                   RpgGameState state = getRpgGameState(this.currentState);

                    assert state != null;

                    RpgGame.getInstance().getPlayer().locationName = this.currentState.name();

                    state.update();

                    continue;

                case Plains1:

                    continue;

                case SkaburnVillage:

                    continue;

                case Quit:

                 
                    Save.savePlayerData();
                    Save.saveBankData();
                    Save.saveQuestMangerData();
                    System.out.println("Game saved");

                    break gameLoop;

            }
        }
    }

    public static void main(String[] args) {

    }


}
