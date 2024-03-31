package saveFolder;
import mainApp.RpgGame;
import questPack.Quest;
import questPack.QuestManager;
import rpgBasePack.Equipment;
import rpgBasePack.BaseAttributes;
import rpgBasePack.Inventory;
import rpgPlayerPack.PlayerWarrior;
import rpgLocationPack.Bank;

import java.io.*;

public class Save {


    private static final File playerDataFile = new File("./saveFolder/SaveFile.txt");
    public static File getPlayerDataFile(){

        return playerDataFile;
    }

    private static final File bankDataFile = new File("./saveFolder/BankData.txt");

    public static File getBankDataFile(){
        return bankDataFile;
    }

    private static final File questManagerFile = new File("./saveFolder/QuestManagerData.txt");

    public static File getQuestManagerFile(){

        return questManagerFile;
    }

    public static void savePlayerData(){

        PlayerWarrior player = RpgGame.getInstance().getPlayer();

        try (PrintWriter output = new PrintWriter(new FileWriter(playerDataFile, false))) {

            output.println(player.getClass().getSimpleName());
            output.println(player.getName());
            output.println(player.getMaxHealth());
            output.println(player.getHealth());
            output.println(player.getExperience());

            BaseAttributes attr = player.getAttributes();

            output.println(attr.getVitality());
            output.println(attr.getAttack());
            output.println(attr.getMagic());
            output.println(attr.getDefence());
            output.println(attr.getMagicDefence());
            output.println(attr.getSpeed());

            output.println((player.getAttributesPoints()));

            output.println(player.getGold().getCount());

            output.println(player.locationName);

            if(QuestManager.questInProgress()){

                Quest quest = QuestManager.getQuest();
                output.println("Quest");
                output.println(quest.getClass().getSimpleName());
                output.println(quest.getQuestData());


            }

            Inventory inventory = player.getInventory();

            output.println("Inventory");
            for(int itemIndex = 0; itemIndex < inventory.getCount(); itemIndex++){

                    output.println(inventory.getItem(itemIndex).getClass().getSimpleName());

                    output.println(inventory.getItem(itemIndex).getCount());
            }

            Equipment equipment = player.getEquipment();

            output.println("Equipment");

            for(int itemIndex = 0; itemIndex < equipment.getCount(); itemIndex++){
                output.println(equipment.getItem(itemIndex).getClass().getSimpleName());
            }


            output.flush();

        } catch (IOException exc) {
        }
    }

    public static void saveBankData(){

        try(PrintWriter output = new PrintWriter(new FileWriter(getBankDataFile(), false)))
        {

            Bank bankInstance = Bank.getInstance();

            output.print(bankInstance.getBankData());

        }catch(IOException exc){

        }
    }

    public static void saveQuestMangerData(){

       try(PrintWriter output = new PrintWriter(new FileWriter(getQuestManagerFile(), false))){

           Object[] quests = QuestManager.getCompletedQuests();

           for(Object o : quests) {
               if(o instanceof Quest quest){
                  output.print(quest.getClass().getSimpleName() + " "+ quest.getQuestData());
               }
           }

       }catch(IOException exc)
       {

       }
    }
}
