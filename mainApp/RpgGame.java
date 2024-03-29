package mainApp;
import java.util.InputMismatchException;
import java.util.Scanner;

import rpgItemPack.*;
import rpgPlayerPack.PlayerMage;
import rpgPlayerPack.PlayerWarrior;
import rpgPlayerPack.PlayerSwordsman;
import adminPack.RpgAdminStateMachine;
import rpgStateMachinePack.RpgGameStateMachine;
import saveFolder.Load;
import saveFolder.Save;

class PlayerCreator {


    private static PlayerWarrior playerInstance = null;
    private PlayerCreator(){

    }

    private static PlayerWarrior createSwordsman(String name){

        playerInstance =  new PlayerSwordsman(name);
        return playerInstance;
    }

    private static PlayerWarrior createMage(String name){
        playerInstance = new PlayerMage(name);
        return playerInstance;
    }

    public static PlayerWarrior getPlayerInstance(){

        return playerInstance;
    }

    public static void setPlayerInstance(PlayerWarrior instance)
    {
        playerInstance = instance;
    }

    public static PlayerWarrior createPlayerWarrior()
    {


        while(true) {

            System.out.println("Select a warrior class using the corresponding number.");
            System.out.println("1. Swordsman");
            System.out.println("2. Mage");

            System.out.print("Choice: ");
            int choice = 0;

            try {

                 choice = RpgGame.getInput().nextInt();

            }catch(InputMismatchException exc)
            {

                System.out.println("Please enter a numbers available");
                RpgGame.getInput().nextLine();
                continue;
            }

            switch (choice)
            {
                case 1: {
                    RpgGame.getInput().nextLine();
                    System.out.println("What is your name?");

                    String name = RpgGame.getInput().nextLine();

                    System.out.println();

                    PlayerWarrior playerWarrior = createSwordsman(name);


                    IronChainMailCoif ironChainMailCoif = new IronChainMailCoif(playerWarrior);
                    playerWarrior.setHeadArmor(ironChainMailCoif);

                    IronChainMail ironChainMail = new IronChainMail(playerWarrior);
                    playerWarrior.setTorsoArmor(ironChainMail);

                    IronChainMailLeggings ironLeggings = new IronChainMailLeggings(playerWarrior);
                    playerWarrior.setLegArmor(ironLeggings);

                    IronPlateBoots ironBoots = new IronPlateBoots(playerWarrior);
                    playerWarrior.setFeetArmor(ironBoots);

                    PlayerSwordsman playerSwordsman = (PlayerSwordsman) playerWarrior;

                    IronSword ironSword = new IronSword(playerSwordsman);
                    playerSwordsman.setPrimaryWeapon(ironSword);

                    IronShield ironShield = new IronShield(playerSwordsman);
                    playerSwordsman.setSecondaryWeapon(ironShield);


                    playerSwordsman.getEquipment().addItem(ironChainMailCoif);
                    playerSwordsman.getEquipment().addItem(ironChainMail);
                    playerSwordsman.getEquipment().addItem(ironLeggings);
                    playerSwordsman.getEquipment().addItem(ironBoots);
                    playerSwordsman.getEquipment().addItem(ironSword);
                    playerSwordsman.getEquipment().addItem(ironShield);

                    return playerSwordsman;
                }
                case 2: {

                    RpgGame.getInput().nextLine();
                    System.out.println("What is your name?");

                    String name = RpgGame.getInput().nextLine();

                    System.out.println();


                    PlayerWarrior playerMage = createMage(name);

                    //set and add armor and weapons to equipment
                    SatinShawl shawl = new SatinShawl(playerMage);
                    playerMage.setHeadArmor(shawl);
                    playerMage.getEquipment().addItem(shawl);

                    SatinCloak cloak = new SatinCloak(playerMage);
                    playerMage.setTorsoArmor(cloak);
                    playerMage.getEquipment().addItem(cloak);

                    SatinLegWraps legWraps = new SatinLegWraps(playerMage);
                    playerMage.setLegArmor(legWraps);
                    playerInstance.getEquipment().addItem(legWraps);

                    SatinFootWraps footWraps = new SatinFootWraps(playerMage);
                    playerMage.setFeetArmor(footWraps);
                    playerMage.getEquipment().addItem(footWraps);

                    StaffCedar staff = new StaffCedar();
                    playerMage.setPrimaryWeapon(staff);
                    playerMage.getEquipment().addItem(staff);

                    SpellBookLv1 book = new SpellBookLv1();
                    playerMage.setSecondaryWeapon(book);
                    playerMage.getEquipment().addItem(book);

                    return playerMage;
                }
                default:
                    System.out.println("Invalid Input.");
                    System.out.println();

            }


        }

    }
}

public class RpgGame {


    private static RpgGame instance = null;

    private final static Scanner input = new Scanner(System.in);
    private RpgGame(){}


    public PlayerWarrior getPlayer(){

      return PlayerCreator.getPlayerInstance();
    }

    public  void setPlayer(PlayerWarrior player){

        PlayerCreator.setPlayerInstance(player);
    }

   public PlayerSwordsman getSwordsman()
   {
       if(getPlayer() instanceof PlayerSwordsman swordsman) {

           return swordsman;
       }

       return null;
   }

    public static RpgGame getInstance(){

        if(instance ==  null){

            instance = new RpgGame();

            return instance;
        }

        return instance;
    }


    public static Scanner getInput(){
        return input;
    }

    private void newGame(){

        PlayerWarrior playerWarrior = PlayerCreator.createPlayerWarrior();

        Item playerGold = new Item("Gold", "It's Gold!",0);

        playerGold.setCount(500);

        playerGold.setStackable(true);

        playerWarrior.setGold(playerGold);

        playerWarrior.displayPlayerProfile();

        playerWarrior.locationName = "DestinyTown";
    }

    public void update(){


     //continue or new game

       if(Save.getPlayerDataFile().exists())
       {
           exitLoop:
           while(true) {
               System.out.println("Would you like to continue or start a new game?");

               System.out.println("1. Continue");
               System.out.println("2. New Game");

               System.out.print("Option: ");

               char input = RpgGame.getInput().next().charAt(0);

               System.out.println();
               switch (input) {

                   case '1':

                       PlayerCreator.setPlayerInstance(Load.loadPlayerData());
                       Load.loadBankData();
                       Load.loadQuestManagerData();


                       break exitLoop;

                   case '2':
                        newGame();
                       break exitLoop;
               }
           }

       }else{


           newGame();

       }


       while(true){

           System.out.println("What mode would you like to play in?");
           System.out.println("1. Game Mode");
           System.out.println("2. Admin Mode");
           System.out.print("Option: ");


           int option;

           try{

               option = getInput().nextInt();
               System.out.println();
           }catch (InputMismatchException exc)
           {
               getInput().nextLine();
               continue;
           }

           if(option == 1)
           {

               RpgGameStateMachine.getMainInstance().setState(getPlayer().locationName);
               getPlayer().getPlayerInventory().setCurrentPlayer(getPlayer());
               getPlayer().getEquipment().setCurrentPlayer(getPlayer());
              break;

           }else if(option == 2)
           {
               RpgAdminStateMachine.setAdminPlayer(RpgGame.getInstance().getPlayer().clone());
               RpgAdminStateMachine.getInstance().update();
               break;
           }else{

               System.out.println("Invalid Input");

           }


       }


        RpgGameStateMachine.getMainInstance().update();


        /*
        IronSword ironSword = new IronSword((PlayerSwordsman) warrior);

        ArmorTorso chainMail = new ArmorTorso("Iron Chain Mail", "Chain mail made of iron.", 35, warrior,
                new BaseAttributes(0.0,0.0,0.0,3.0, 0.0, -1.0) );

        warrior.getPlayerInventory().addItem(ironSword);

        warrior.getPlayerInventory().addItem(chainMail);

        warrior.getPlayerInventory().use();

       // warrior.getEquipment().displayItems();

        warrior.getEquipment().use();

        warrior.displayTotalAttributes();

        warrior.getEquipment().use();

        warrior.displayTotalAttributes();

       */
    }



}
