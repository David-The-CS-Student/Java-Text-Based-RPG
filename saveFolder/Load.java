package saveFolder;

import java.io.File;


import questPack.Quest;
import questPack.QuestManager;
import questPack.GiantRatQuest;
import rpgBasePack.RpgCalculator;
import rpgItemPack.*;
import rpgBasePack.BaseAttributes;
import rpgLocationPack.Bank;
import rpgLocationPack.DestinyTown;
import rpgPlayerPack.*;
import rpgStateMachinePack.RpgGameStateMachine;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
import java.io.*;

public class Load {




    public static PlayerWarrior loadPlayerData(){

        try(Scanner scan = new Scanner(Save.getPlayerDataFile()))
        {

            PlayerWarrior loadPlayer = null;
            while(scan.hasNext())
            {
               String data =  scan.next();

               loadPlayer = switch(data){
                  case "PlayerSwordsman" -> new PlayerSwordsman();

                   case "PlayerMage" -> new PlayerMage();

                   default -> null;

               };



                data = scan.next() + scan.nextLine();

               assert loadPlayer != null;
                loadPlayer.setInventory(new PlayerInventory());
                loadPlayer.setEquipment(new PlayerEquipment());
                loadPlayer.setName(data);

               double doubleData = scan.nextDouble();

               loadPlayer.setMaxHealth(doubleData);

               doubleData = scan.nextDouble();

               loadPlayer.setHealth(doubleData);

               int intData = scan.nextInt();

               loadPlayer.setExperience(intData);

               loadPlayer.setLevel(RpgCalculator.levelCalculator(loadPlayer.getExperience()));

               doubleData = scan.nextDouble();

               BaseAttributes playerAttributes = new BaseAttributes();

               playerAttributes.setVitality(doubleData);

               loadPlayer.addTotalVitalityPoints(playerAttributes.getVitality());

               doubleData = scan.nextDouble();

               playerAttributes.setAttack(doubleData);

               doubleData = scan.nextDouble();

               playerAttributes.setMagic(doubleData);

               doubleData = scan.nextDouble();

               playerAttributes.setDefence(doubleData);

               doubleData = scan.nextDouble();

               playerAttributes.setMagicDefence(doubleData);

               doubleData = scan.nextDouble();

               playerAttributes.setSpeed(doubleData);

               loadPlayer.setAttributes(playerAttributes);

               loadPlayer.initializeTotalAttributes();

               intData = scan.nextInt();

               loadPlayer.addAttributesPoints(intData);

               int goldCount = scan.nextInt();

                Item playerGold = new Item("Gold", "It's Gold!",0);

                playerGold.setCount(goldCount);

                loadPlayer.setGold(playerGold);

                String gameStateData = scan.next();

                loadPlayer.locationName = gameStateData;

               if(scan.hasNext("Quest")) {
                   String questData = scan.next();

                   if (questData.equals("Quest")) {

                       questData = scan.next();
                       try {
                           Class<?> questClass = Class.forName("questPack." + questData);

                           Quest quest = (Quest) questClass.getDeclaredConstructor().newInstance();

                           Object[] questObjectiveData = new Object[quest.getObjectiveCount()];

                           //create overridable method that sets values for particular quest
                           int objectiveCounter = 0;
                           while(objectiveCounter < quest.getObjectiveCount())
                           {

                               questObjectiveData[objectiveCounter] = scan.next();

                               objectiveCounter++;
                           }

                           quest.setActive(true);
                           quest.setObjectiveValues(questObjectiveData);

                           QuestManager.setQuest(quest);


                       } catch (ClassNotFoundException | InvocationTargetException | InstantiationException |
                                IllegalAccessException | NoSuchMethodException e) {
                           throw new RuntimeException(e);
                       }

                   }
               }

                if(scan.hasNext("Inventory")) {

                    String inventoryData = scan.next();
                    System.out.println(inventoryData);
                    if (inventoryData.equals("Inventory")) {

                        while (!inventoryData.equals("Equipment")) {


                            inventoryData = scan.next();

                            System.out.println(inventoryData);

                            if (!inventoryData.equals("Equipment")) {
                                try {

                                    Class<?> itemClass = Class.forName("rpgItemPack." + inventoryData);

                                    Item item = (Item) itemClass.getDeclaredConstructor().newInstance();

                                    item.setPlayerOwner(loadPlayer);

                                    //scan for amount change item count here

                                    int itemCount = scan.nextInt();

                                    item.setCount(itemCount);

                                    loadPlayer.getInventory().addItem(item);


                                } catch (ClassNotFoundException | InvocationTargetException | InstantiationException |
                                         IllegalAccessException | NoSuchMethodException e) {

                                    throw new RuntimeException(e);
                                }
                            }
                        }

                    }
                }

                while(scan.hasNext()){


                    String equipmentData = scan.next();



                    if(!equipmentData.equals("Equipment")) {
                        try {

                            Class<?> itemClass = Class.forName("rpgItemPack." + equipmentData);

                            Item item = (Item) itemClass.getDeclaredConstructor().newInstance();


                            item.setPlayerOwner(loadPlayer);
                            loadPlayer.getEquipment().addItem(item);

                            if (item instanceof IEquipable equipable) {

                                equipable.equip();
                            }


                        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException |
                                 IllegalAccessException | NoSuchMethodException e) {
                            throw new RuntimeException(e);
                        }


                    }

                }


//            output.println(attr.getVitality());
//            output.println(attr.getAttack());
//            output.println(attr.getMagic());
//            output.println(attr.getDefence());
//            output.println(attr.getMagicDefence());
//            output.println(attr.getSpeed());


             return loadPlayer;


            }


             //assert loadPlayer != null;



        }catch(FileNotFoundException exc){



        }


     return null;

    }


    public static void loadBankData(){


        try(Scanner scan = new Scanner(Save.getBankDataFile()))
        {

           while (scan.hasNext())
           {

               String itemData = scan.next();
               try{

                   Class<?> itemClass = Class.forName("rpgItemPack." + itemData);

                   Item item = (Item) itemClass.getDeclaredConstructor().newInstance();

                   int itemCount = scan.nextInt();

                   item.setCount(itemCount);

                   Bank.getInstance().add(item);

               } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException |
                        InstantiationException | InvocationTargetException e) {
                   throw new RuntimeException(e);
               }
           }

        }catch(IOException exc)
        {


        }
    }

    public static void loadQuestManagerData(){


        try(Scanner scan = new Scanner(Save.getQuestManagerFile()))
        {

            while(scan.hasNext())
            {
                try{

                    String questClassName = scan.next();
                    Class<?> questClass = Class.forName("questPack."+ questClassName );

                    Quest quest = (Quest) questClass.getDeclaredConstructor().newInstance();

                    Object[] questData = new Object[quest.getObjectiveCount()];

                    for(int dataIndex = 0; dataIndex < questData.length; dataIndex++)
                    {
                        String data = scan.next();
                        questData[dataIndex] = data;
                    }

                    quest.setObjectiveValues(questData);

                    quest.setActive(false);

                    quest.setComplete(true);

                    QuestManager.addCompletedQuest(quest);


                } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException |
                         InstantiationException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }


            }

        }catch(IOException exc)
        {

        }


    }

}
