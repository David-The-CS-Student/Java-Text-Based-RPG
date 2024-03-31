package adminPack;

import generics.Array;

import mainApp.RpgGame;
import rpgLocationPack.Bank;
import rpgLocationPack.Location;
import rpgPlayerPack.PlayerWarrior;
import rpgStateMachinePack.RpgGameStateMachine;
import saveFolder.Save;
import java.util.InputMismatchException;

enum AdminState{


    MainMenu,
    Leveling,
    Profile,

    Items,

    Bank,

    Battle,

    Quit,

    Save,

}
public class RpgAdminStateMachine {


    private static RpgAdminStateMachine instance = null;


    private Array<RpgAdminState> adminStates;


     private AdminState currentState;

    private RpgAdminStateMachine(){
        adminStates = new Array<>(3);

        adminStates.add(new AdminLevelingState());
        adminStates.add(new AdminItemsState());
        adminStates.add(new AdminBattleState());

        this.currentState = AdminState.MainMenu;
    }

   private static PlayerWarrior adminPlayer;

    public static void setAdminPlayer(PlayerWarrior currentPlayerData){

        adminPlayer = currentPlayerData;
    }

    public static PlayerWarrior getAdminPlayer(){
        return adminPlayer;
    }

    public static RpgAdminStateMachine getInstance(){

        if(instance == null)
        {
            instance = new RpgAdminStateMachine();

            return  instance;
        }

        return instance;
    }

    public AdminState getCurrentState() {
        return this.currentState;
    }

    public void setCurrentState(AdminState nextState)
    {
        this.currentState = nextState;
    }

    public RpgAdminState getAdminState(AdminState state){

        for(int stateIndex = 0; stateIndex < adminStates.getCount(); stateIndex++ )
        {
            RpgAdminState adminState = adminStates.getObject(stateIndex);

            if(adminState.getState() == state)
            {
                return adminState;
            }
        }

        return null;
    }

    private void mainMenu(){

        mainLoop:
        while(true){

            System.out.println("Admin Mode: select the following options");

            System.out.println("1. Leveling");
            System.out.println("2. Player Profile");
            System.out.println("3. Heal Player");
            System.out.println("4. Items");
            System.out.println("5. Banking");
            System.out.println("6. Battle");
            System.out.println("7 Quit");

            System.out.print("Option: ");


            int adminOptions;

            try{

                adminOptions = RpgGame.getInput().nextInt();
                System.out.println();
            }catch(InputMismatchException exc)
            {

                RpgGame.getInput().nextLine();
                continue;
            }

            switch(adminOptions)
            {

                case 1:

                    this.setCurrentState(AdminState.Leveling);

                    break mainLoop;

                case 2:

                    this.setCurrentState(AdminState.Profile);
                    break mainLoop;

                case 3:

                    PlayerWarrior player = RpgAdminStateMachine.getAdminPlayer();
                    player.setHealth(player.getMaxHealth());
                    System.out.println(player.getName() + " is at full health.");
                    System.out.println();
                    continue;

                case 4:

                    this.currentState = AdminState.Items;
                    break mainLoop;


                case 5:

                    this.currentState = AdminState.Bank;
                    break mainLoop;

                case 6:

                    this.currentState = AdminState.Battle;
                    break mainLoop;

                case 7:

                    this.setCurrentState(AdminState.Save);

                    break mainLoop;
            }


        }
    }

    private  void saveMenu()
    {


        while(true){

            System.out.println("Would you like to save?");
            System.out.println("(y)es or (n)o");
            System.out.print("Option: ");

            char input = RpgGame.getInput().next().charAt(0);

            System.out.println();
            if(input == 'y')
            {
                RpgGame.getInstance().setPlayer(RpgAdminStateMachine.getAdminPlayer());

                Save.savePlayerData();
                Save.saveBankData();

                this.currentState = AdminState.Quit;

                break;
            }else if(input == 'n')
            {
                this.currentState = AdminState.Quit;

                break;
            }else{

                System.out.println("Invalid Input");

            }
        }
    }


    private void quitMenu(){

        while(true) {

            System.out.println("Would you like to switch to Game Mode?");
            System.out.println("1. Game Mode");
            System.out.println("2. Quit Game");
            System.out.print("Option: ");

            int option;

            try{
                option = RpgGame.getInput().nextInt();
                System.out.println();

            }catch (InputMismatchException exc){
                RpgGame.getInput().nextLine();
                continue;
            }

            if( option == 1){
                RpgGameStateMachine.getMainInstance().setState(RpgGame.getInstance().getPlayer().locationName);
                break;

            }else if(option == 2){
                System.exit(1);
                break;
            }
        }
    }

    public void update(){

        mainLoop:
        while(true){

            switch (this.currentState){

                case MainMenu:
                    mainMenu();
                    continue;

                case Leveling, Items, Battle: {

                    RpgAdminState current = this.getAdminState(this.currentState);
                    current.update();

                    continue;
                }

                case Profile:

                    adminPlayer.displayPlayerProfile();
                    this.currentState = AdminState.MainMenu;

                    continue;
                case Bank:

                    Bank.setPlayer(RpgAdminStateMachine.getAdminPlayer());
                    Bank.getInstance().use("Administrator");

                    Bank.setPlayer(null);
                    this.currentState = AdminState.MainMenu;

                    continue;
                case Save:

                    saveMenu();
                    continue;

                case Quit:
                    quitMenu();
                    break mainLoop;
            }
        }
    }
}
