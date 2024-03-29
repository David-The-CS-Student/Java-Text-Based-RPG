package adminPack;
import mainApp.*;
import rpgBasePack.RpgCalculator;
import rpgPlayerPack.PlayerWarrior;

import java.util.InputMismatchException;

public class AdminLevelingState extends RpgAdminState {



    public AdminLevelingState(){super(AdminState.Leveling);}


    @Override
    public void update() {


        while(true){

            System.out.println("Leveling State: Do you wish to level up your player?");
            System.out.println("1. Level up!");
            System.out.println("2. Main Menu");



            int adminChoice;

            try{
                adminChoice = RpgGame.getInput().nextInt();

            }catch (InputMismatchException exc)
            {
                RpgGame.getInput().nextLine();
                System.out.println("Invalid Input");
                continue;
            }


            if(adminChoice == 1)
            {
              //level up!

                PlayerWarrior player = RpgAdminStateMachine.getAdminPlayer();
                int nextExp = RpgCalculator.expCalculator(player.getLevel()+1);

               player.setExperience(nextExp);

                int nextLevel = RpgCalculator.levelCalculator(nextExp);

               player.setLevel(nextLevel);

                System.out.println(player.getName() + " is now level " + player.getLevel() + "!");
                System.out.println();

                player.addAttributesPoints(6);

            }else if(adminChoice == 2)
            {
                //change to main state
                RpgAdminStateMachine.getInstance().setCurrentState(AdminState.MainMenu);
                break;

            }else{

                System.out.println("Invalid Input");
            }
        }

    }

    @Override
    public String toString() {
        return getState().name();
    }
}
