
package rpgStateMachinePack;
import rpgLocationPack.Bank;
import rpgLocationPack.DestinyTown;
import mainApp.RpgGame;

import java.util.InputMismatchException;

public class DestinyTownState extends RpgGameState{

    DestinyTown destinyTown;

    public DestinyTownState(){

        super(GameState.DestinyTown);
        destinyTown = new DestinyTown();
    }


    @Override
    public void update() {

        while (true) {

            System.out.println("You have arrived at " + destinyTown.getName() +". Select the following options.");

            System.out.println("1. Visit Store");
            System.out.println("2. Enter The Town Sewers");
            System.out.println("3. Quest Board");
            System.out.println("4. Got to Bank");
            System.out.println("5. Rest at the Inn");
            System.out.println("6. Player Profile");
            System.out.println("7. Leave Town");
            System.out.println("8. Quit Game");

            int choice = 0;

            try{

                choice =  RpgGame.getInput().nextInt();

            }catch(InputMismatchException exc)
            {

                RpgGame.getInput().nextLine();
                continue;
            }


            if(choice == 1)
            {
                destinyTown.getDestinyTownStore().displayStoreOptions();

            }else if(choice == 2){

              destinyTown.displaySewersOption();
            }else if(choice == 3)
            {
                destinyTown.displayQuestBoard();
            }
            else if(choice == 4){

                destinyTown.displayBank();
            }
            else if(choice == 5){

                destinyTown.restAtInn();
            }
            else if(choice == 6){

                RpgGame.getInstance().getPlayer().displayPlayerProfile();

            }else if(choice == 7){

            //change to Plain1 one
            //exit while loop

            }else if(choice == 8){

                RpgGameStateMachine.getMainInstance().setState(GameState.Quit);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return getState().name();
    }
}
