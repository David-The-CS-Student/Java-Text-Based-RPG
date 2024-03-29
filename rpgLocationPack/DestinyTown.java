package rpgLocationPack;
import generics.Array;
import questPack.QuestManager;
import questPack.Quest;
import rpgBasePack.GameCharacter;
import mainApp.RpgGame;
import rpgBattlePack.Battle;
import rpgEnemyPack.EnemyCharacter;
import rpgEnemyPack.EnemyCreator;
import rpgEnemyPack.GiantRat;
import rpgItemPack.*;
import questPack.GiantRatQuest;

import java.util.InputMismatchException;
import java.util.Random;
class DestinyTownSewers extends Location{


    EnemyCharacter enemyCharacterInstance;


    public DestinyTownSewers(){

        super("Destiny Town Sewers");


    }



    public void displaySewerOptions()
    {

        while(true)
        {
            System.out.println("You are in the " + getName() + ". Select the following options.");

            System.out.println("1. Explore");
            System.out.println("2. Player Profile");
            System.out.println("3. Leave");

            int playerChoice = 0;
            try {

                 playerChoice = RpgGame.getInput().nextInt();

            }catch(InputMismatchException exc)
            {
                RpgGame.getInput().nextLine();
                continue;
            }

            if(playerChoice == 1){
                if(RpgGame.getInstance().getPlayer().getHealth() > 0)
                {
                    explore();

                }else{

                    System.out.println("you are to weak to explore you need to heal");
                    System.out.println();
                }
            }else if(playerChoice == 2)
            {
                RpgGame.getInstance().getPlayer().displayPlayerProfile();
                
            } else if (playerChoice == 3) {

                break;
            }

        }

    }

    private void explore()
    {

        Random random = new Random();

        int randomNumber = random.nextInt(2);

        if(randomNumber == 0)
        {
            Random rndEnemy = new Random();

            int rndEnemyVale = rndEnemy.nextInt(2);

            switch(rndEnemyVale){

                case 0:
                    enemyCharacterInstance = EnemyCreator.creatGiantRat();

                    break;
                case 1:
                    enemyCharacterInstance = EnemyCreator.creatGiantSpider();

                    break;

            }

            Battle encounter = new Battle(RpgGame.getInstance().getPlayer(), enemyCharacterInstance);
            encounter.update();

            if(RpgGame.getInstance().getPlayer().getHealth() > 0) {
                if (QuestManager.questInProgress()) {
                    if (QuestManager.getQuest() instanceof GiantRatQuest quest) {
                        if (enemyCharacterInstance instanceof GiantRat) {
                            quest.incrementRatKillCount(enemyCharacterInstance);
                            if(enemyCharacterInstance.getCurrentDrop() != null) {
                                quest.incrementRatPeltCount(enemyCharacterInstance.getCurrentDrop());
                            }
                        }

                        if (quest.isComplete()) {
                            int reward = quest.getReward() +  RpgGame.getInstance().getPlayer().getGold().getCount();
                            RpgGame.getInstance().getPlayer().getGold().setCount(reward);
                            QuestManager.addCompletedQuest(quest);
                            QuestManager.getQuest().setActive(false);
                            QuestManager.setQuest(null);

                            System.out.println("Congratulations you completed the quest " + quest.getName() + "!");
                            System.out.println("You received " + quest.getReward() + " gold as a reward!");
                        }

                    }
                }

            }




        }else{

            System.out.println("You found nothing in the sewers");
            System.out.println();

        }




    }


}

public class DestinyTown extends Location{


    private Store destinyTownStore;

    private DestinyTownSewers destinyTownSewers;

    private static final Array<Quest> quests = new Array<>(2);

    //Questboard
    //

    public DestinyTown(){

        super("Destiny Town");

        destinyTownSewers = new DestinyTownSewers();
        destinyTownStore = new Store("Destiny Town Store", 7);

        destinyTownStore.addItem(new PotionHealthSmall());
        destinyTownStore.addItem(new PotionWater());
        destinyTownStore.addItem(new BlessedNecklace());
        destinyTownStore.addItem(new Bones());
        destinyTownStore.addItem(new RingOfPace());

        for(Object o : QuestManager.getCompletedQuests())
        {
            if(o instanceof GiantRatQuest quest)
            {
                quests.add(quest);
            }
        }


        if(quests.getCount() == 0 && !QuestManager.questInProgress())
        {

            quests.add(new GiantRatQuest());

        }else if (quests.getCount() == 0 && QuestManager.questInProgress()){

            if(QuestManager.getQuest() instanceof GiantRatQuest)
            {
                quests.add(QuestManager.getQuest());
                getGiantRatQuest().setActive(true);
            }else{

                quests.add(new GiantRatQuest());
            }

        }

    }


    public Store getDestinyTownStore() {
        return destinyTownStore;
    }

    private DestinyTownSewers getDestinyTownSewers() {
        return destinyTownSewers;
    }

    public void displayQuestBoard(){
        while(true){

            System.out.println("Destiny Town Quest Board. Select a quest");
            int choice = 0;
            for(int questIndex = 0; questIndex < quests.getCount(); questIndex++)
            {
                System.out.println((questIndex +1) + ". " + quests.getObject(questIndex).getName() +
                        " | Difficulty: " + quests.getObject(questIndex).getDifficultyStatus() +
                        " | Active: " + quests.getObject(questIndex).isActive() +
                        "| Completed " + quests.getObject(questIndex).isComplete()

                );
            }

            System.out.println((quests.getCount() +1) + ". Back");

            try{

                System.out.print("Choice: ");
                choice = RpgGame.getInput().nextInt();

                while(choice > 0 && choice <(quests.getCount()+1))
                {
                    if(!quests.getObject(choice-1).isComplete()) {
                        if (!quests.getObject(choice-1).isActive()) {
                            quests.getObject(choice-1).displayQuestInfo();

                            try {
                                System.out.println("1. Accept");
                                System.out.println("2. Back");
                                System.out.print("Choice: ");
                                choice = RpgGame.getInput().nextInt();

                                if (choice == 1) {
                                    System.out.println("You started the quest " + quests.getObject(choice-1).getName());

                                    QuestManager.setQuest(quests.getObject(choice -1));
                                    QuestManager.getQuest().setActive(true);

                                    break;

                                } else {

                                    choice = 0;
                                    break;

                                }
                            } catch (InputMismatchException exc) {

                                System.out.println("Input not valid");
                                RpgGame.getInput().nextLine();
                            }

                        } else {
                            System.out.println("This quest is currently active");
                            break;
                        }
                    }else{
                        System.out.println("This quest is completed");
                        break;
                    }
                }

                if(choice == (quests.getCount()+1)){

                    break;
                }

                if(choice <= 0 && choice > quests.getCount()+1) {
                    System.out.println("Input not valid");
                }

            }catch(InputMismatchException exc){

                System.out.println("Input not valid");
                RpgGame.getInput().nextLine();
            }

        }
    }

    public void displayBank(){

        Bank.setPlayer(RpgGame.getInstance().getPlayer());
        Bank.getInstance().use(this.getName());
        Bank.setPlayer(null);
    }

    public void displaySewersOption(){
        destinyTownSewers.displaySewerOptions();
    }
    public void restAtInn(){

        System.out.println("You slept at the Inn and are fully rested");

        GameCharacter player = RpgGame.getInstance().getPlayer();

        player.setHealth(player.getMaxHealth());


    }

   public static GiantRatQuest getGiantRatQuest(){

        return (GiantRatQuest) quests.getObject(0);
    }
}
