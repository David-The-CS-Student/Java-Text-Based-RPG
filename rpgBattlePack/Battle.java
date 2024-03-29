package rpgBattlePack;
import mainApp.RpgGame;
import rpgBasePack.RpgCalculator;
import rpgItemPack.Item;
import rpgItemPack.Consumable;
import rpgPlayerPack.PlayerWarrior;
import rpgEnemyPack.EnemyCharacter;
import rpgItemPack.Armor;
import rpgItemPack.Weapon;

import java.util.InputMismatchException;
import java.util.Random;
public class Battle {


    private PlayerWarrior playerWarrior;

    private EnemyCharacter enemyCharacter;


    private boolean isFirstAttack = false;
    private boolean isPlayerTurn = false;


    private static boolean isBattle = false;
    public Battle(PlayerWarrior player, EnemyCharacter enemy){

        this.playerWarrior = player;
        this.enemyCharacter = enemy;

    }

    public void update() {

        System.out.println(playerWarrior.getName() + " encountered a " + enemyCharacter.getName() + ".");

        Battle.setIsBattle(true);
        exitBattle:
        while (true)
        {
            System.out.println("Select the following options.");

            System.out.println("Player Name: " + playerWarrior.getName() + " | "+ "Lv: "+ playerWarrior.getLevel() + " | " + "Health Points: " + playerWarrior.getHealth());

            System.out.println("Enemy Name: " + enemyCharacter.getName() + " | "+ "Lv: "+ enemyCharacter.getLevel() + " | " + "Health Points: " + enemyCharacter.getHealth());

            System.out.println("1. Attack");
            System.out.println("2. Inventory");
            System.out.println("3. Run");
            System.out.print("Choice: ");


            int playerChoice = 0;

            try {
                playerChoice = RpgGame.getInput().nextInt();

            }catch(InputMismatchException exc)
            {
                RpgGame.getInput().nextLine();
                continue;
            }
            System.out.println();
            if (playerChoice == 1) {

                if (!isFirstAttack) {

                    if(playerWarrior.getTotalSpeedPoints() > enemyCharacter.totalSpeedPoints) {

                        isPlayerTurn = true;

                    }else if(playerWarrior.getTotalSpeedPoints() == enemyCharacter.totalSpeedPoints)
                    {
                        Random rnd = new Random();
                        int rndNumber = rnd.nextInt(2);

                        switch(rndNumber)
                        {
                            case 0: isPlayerTurn = true; break;

                            case 1: isPlayerTurn = false; break;
                        }
                    }

                    isFirstAttack = true;
                }

                if (isPlayerTurn) {


                    playerWarrior.attack(enemyCharacter);

                    if(enemyCharacter.getHealth() <= 0)
                    {
                        System.out.println("You defeated a " + enemyCharacter.getName());
                        System.out.println("You gained " + enemyCharacter.getExperience() + " points");

                        int newExp = playerWarrior.getExperience() + enemyCharacter.getExperience();

                        playerWarrior.setExperience(newExp);

                        if(playerWarrior.getExperience() >= playerWarrior.getExpToNextLv())
                        {
                            System.out.println("Congratulations you leveled up!!!");

                            playerWarrior.setLevel(RpgCalculator.levelCalculator(playerWarrior.getExperience()));

                            playerWarrior.addAttributesPoints(6);

                        }

                        System.out.println(playerWarrior.getExperience() + "/" + playerWarrior.getExpToNextLv() + " until next level" );
                        System.out.println("You need " + (playerWarrior.getExpToNextLv() - playerWarrior.getExperience()) + " experience to level up.");

                        Item dropItem = enemyCharacter.drop();
                        enemyCharacter.setCurrentDrop(dropItem);
                        System.out.println("The " + enemyCharacter.getName() + " Drops " + dropItem.getName());

                        exitDropLoop:
                        while (true) {
                            System.out.println();
                            System.out.println("Would you like the procure this item");

                            System.out.print("Press [y]es or [n]o: ");
                            char dropChoice = RpgGame.getInput().next().charAt(0);
                            System.out.println();

                            switch(dropChoice)
                            {
                                case 'y':


                                    playerWarrior.getPlayerInventory().addItem(dropItem);
                                    System.out.println();
                                    break exitDropLoop;

                                case 'n':

                                    break exitDropLoop;

                                default:
                                    System.out.println("Invalid Input");
                                    System.out.println();
                            }


                        }

                        System.out.println();
                        break;
                    }


                    enemyCharacter.attack(playerWarrior);


                    if(playerWarrior.getHealth() <= 0)
                    {
                        System.out.println("You lost and are hurt badly. You need to recover.");
                        System.out.println();
                        break;
                    }


                    System.out.println();

                } else {

                   enemyCharacter.attack(playerWarrior);


                    if(playerWarrior.getHealth() <= 0)
                    {
                        System.out.println("You lost and are hurt badly. You need to recover.");
                        System.out.println();
                        break;
                    }

                   playerWarrior.attack(enemyCharacter);

                    if(enemyCharacter.getHealth() <= 0)
                    {
                        System.out.println("You defeated a " + enemyCharacter.getName());
                        System.out.println("You gained " + enemyCharacter.getExperience() + " points");


                        int newExp = playerWarrior.getExperience() + enemyCharacter.getExperience();

                        playerWarrior.setExperience(newExp);


                        if(playerWarrior.getExperience() >= playerWarrior.getExpToNextLv())
                        {
                            System.out.println("Congratulations you leveled up!!!");

                            playerWarrior.setLevel(RpgCalculator.levelCalculator(playerWarrior.getExperience()));

                            playerWarrior.addAttributesPoints(6);
                        }

                        System.out.println(playerWarrior.getExperience() + "/" + playerWarrior.getExpToNextLv() + " until next level" );
                        System.out.println("You need " + (playerWarrior.getExpToNextLv() - playerWarrior.getExperience()) + " experience to level up.");

                        Item dropItem = enemyCharacter.drop();
                        enemyCharacter.setCurrentDrop(dropItem);
                        System.out.println("The " + enemyCharacter.getName() + " Drops " + dropItem.getName());

                        exitDropLoop:
                        while (true) {
                            System.out.println();
                            System.out.println("Would you like the procure this item");

                            System.out.print("Press [y]es or [n]o: ");
                            char dropChoice = RpgGame.getInput().next().charAt(0);
                            System.out.println();

                            switch(dropChoice)
                            {
                                case 'y':


                                    playerWarrior.getPlayerInventory().addItem(dropItem);
                                    System.out.println();

                                    break exitDropLoop;

                                case 'n':

                                    break exitDropLoop;

                                default:
                                    System.out.println("Invalid Input");
                                    System.out.println();
                            }


                        }

                        System.out.println();
                        break;
                    }


                    System.out.println();

                }

            } else if (playerChoice == 2) {

                exitInventory:
                while(true) {

                    playerWarrior.getPlayerInventory().displayItems();

                    System.out.println((playerWarrior.getPlayerInventory().getCount() + 1) + ". Back");
                    System.out.print("select an item to inspect using its corresponding number: ");

                    //Input mismatch ecxeption

                    int itemChoice = 0;

                    try {
                        itemChoice = RpgGame.getInput().nextInt();

                    }catch(InputMismatchException exc)
                    {
                        RpgGame.getInput().nextLine();
                        continue;
                    }

                    if (itemChoice == (playerWarrior.getPlayerInventory().getCount() + 1)) {

                        System.out.println();

                        break;
                    }

                    if ((itemChoice - 1) < playerWarrior.getPlayerInventory().getCount()) {

                        Item item = playerWarrior.getPlayerInventory().getItem(itemChoice - 1);

                        if(item.getClass().getSimpleName().equals("Item") || item instanceof Armor || item instanceof Weapon )
                        {
                            System.out.println("You only can use potions in battle");
                            System.out.println();
                            continue;
                        }

                        while (item instanceof Consumable consumable) {
                            System.out.println("Selected Item: " + item.getName());

                            System.out.println("1. Use");
                            System.out.println("2. Back");

                            System.out.print("Select the following option with its corresponding number: ");

                            int optionChoice = RpgGame.getInput().nextInt();

                            if (optionChoice == 1) {

                                consumable.use(playerWarrior);
                                playerWarrior.getPlayerInventory().removeItem(consumable.getId());

                                enemyCharacter.attack(playerWarrior);

                                if (playerWarrior.getHealth() <= 0) {

                                    System.out.println("You lost and are hurt badly. You need to recover.");
                                    System.out.println();
                                    break exitBattle;
                                }

                                break exitInventory;
                            } else if (optionChoice == 2) {

                                break;

                            }
                        }



                    }


                }
            } else if (playerChoice == 3) {

                System.out.println("You got away safely");
                System.out.println();
                break;

            }


        }

        Battle.setIsBattle(false);
    }

    public static boolean getIsBattle(){

        return isBattle;
    }

    public static void setIsBattle(boolean condition)
    {
        isBattle = condition;
    }
}
