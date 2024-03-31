
package rpgLocationPack;
import rpgBasePack.Inventory;
import rpgPlayerPack.PlayerWarrior;
import mainApp.RpgGame;
import rpgItemPack.Item;

import java.lang.reflect.InvocationTargetException;
import java.util.InputMismatchException;

public class Store extends Inventory{

    private String name;

    public Store(String name, int size){
        super(size);
        this.name = name;
    }

    public void displayStoreOptions(){

        while(true) {

            System.out.println("Welcome to the " + this.name + ". Selected the following option");

            System.out.println("1. Buy");
            System.out.println("2. Sell");
            System.out.println("3. Leave");

            int choice = 0;

            try {
                choice = RpgGame.getInput().nextInt();
            }catch(InputMismatchException exc)
            {
                RpgGame.getInput().nextLine();
                continue;
            }
            if(choice == 1)
            {
               displayBuyOptions();

            }else if(choice == 2)
            {
                displaySellOptions();
            }
            else if(choice == 3)
            {
                break;
            }
        }
    }

    private void displayBuyOptions()  {

        PlayerWarrior player = RpgGame.getInstance().getPlayer();

        Item playerGold = player.getGold();

        while(true) {

            System.out.println("Player Name: " + player.getName() + " | Gold: " + playerGold.getCount());
            System.out.println();

            displayItemViews();

            System.out.println((getItemViews().getCount() + 1) + ". Back");
            System.out.print("select an item to inspect using its corresponding number: ");

            int itemChoice = 0;

            try {

                itemChoice = RpgGame.getInput().nextInt();

            }catch(InputMismatchException exc)
            {
                RpgGame.getInput().nextLine();
                continue;
            }

            if (itemChoice == (getItemViews().getCount()+ 1)) {
                break;
            }

            if (itemChoice <= getCount() ) {

                Item chosenItem = getItemViews().getObject(itemChoice - 1).getItem();

                if (chosenItem != null) {

                    if (chosenItem.getPrice() <= playerGold.getCount()) {

                        int newGoldAmount = playerGold.getCount() - chosenItem.getPrice();

                        playerGold.setCount(newGoldAmount);

                        if (!chosenItem.getClass().getSuperclass().getSimpleName().equals("Item")) {

                            try {

                                Class<?> itemClass = Class.forName(chosenItem.getClass().getName());

                                Item item = (Item) itemClass.getDeclaredConstructor().newInstance();

                                item.setPlayerOwner(player);

                                player.getPlayerInventory().addItem(item);

                            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException |
                                     InvocationTargetException | NoSuchMethodException exc) {

                               throw new RuntimeException(exc);

                            }

                        }else{

                            chosenItem.setPlayerOwner(player);

                            player.getPlayerInventory().addItem(chosenItem.clone());
                        }
                    }
                }
            }
        }
    }

    private void displaySellOptions(){

        PlayerWarrior player = RpgGame.getInstance().getPlayer();

        Item playerGold = player.getGold();

        while(true) {

            System.out.println("Player Name: " + player.getName() + " | Gold: " + playerGold.getCount());

            System.out.println();

            player.getPlayerInventory().displayItemViews();

            System.out.println((player.getPlayerInventory().getCount() + 1) + ". Back");

            System.out.print("select an item to sell using its corresponding number: ");

            int itemChoice = 0;

            try {

                itemChoice = RpgGame.getInput().nextInt();

            }catch(InputMismatchException exc)
            {
                RpgGame.getInput().nextLine();
                continue;
            }

            if (itemChoice == (player.getPlayerInventory().getCount() + 1)) {
                break;
            }

            if (itemChoice <= player.getPlayerInventory().getCount() ) {

                Item chosenItem = player.getPlayerInventory().getGetItemView(itemChoice - 1).getItem();

                if (chosenItem != null) {
                    int amount = 1;
                    if(chosenItem.isStackable()) {

                        System.out.println("How many of this item do you want to sell?: ");

                        try {
                            amount = RpgGame.getInput().nextInt();
                        } catch (InputMismatchException exc) {
                            RpgGame.getInput().nextLine();
                            continue;
                        }
                    }

                    if (amount <= chosenItem.getCount()) {
                        Item storeGold = new Item("Gold");

                        storeGold.setStackable(true);

                        storeGold.setCount(chosenItem.getPrice() * amount);

                        int newGoldAmount = playerGold.getCount() + storeGold.getCount();

                        playerGold.setCount(newGoldAmount);

                        player.getPlayerInventory().removeItem(chosenItem.getId());
                    } else {

                        System.out.println("That amount is to many");
                        System.out.println();
                    }

                }
            }else{

                System.out.println("Invalid quantity");
            }
        }

    }
    public String getName() {
        return this.name;
    }
}
