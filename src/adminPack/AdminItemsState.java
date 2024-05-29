package adminPack;

import mainApp.RpgGame;
import rpgBasePack.Inventory;
import rpgItemPack.Item;
import rpgPlayerPack.PlayerWarrior;

import java.lang.reflect.InvocationTargetException;
import java.util.InputMismatchException;

public class AdminItemsState extends RpgAdminState{


    public AdminItemsState(){super(AdminState.Items);}


    @Override
    public void update() {

        while (true) {

            System.out.println("Select an option");
            System.out.println("1. Add Item");
            System.out.println("2. Main Menu");

            System.out.print("Option: ");
            int option;

            try {
                option = RpgGame.getInput().nextInt();
                System.out.println();
            } catch (InputMismatchException exc) {
                RpgGame.getInput().nextLine();
                continue;
            }

            if (option == 1) {

                while(true) {

                    System.out.println("Please enter class name of the item you want to add to your inventory or (e) to exit");
                    System.out.print("Class Name: ");

                    String input = RpgGame.getInput().next();

                    if(input.equals("e"))
                    {
                        break;
                    }

                    System.out.println();

                    try {

                        Class<?> itemClass = Class.forName("rpgItemPack." + input);

                        Item newItem = (Item) itemClass.getDeclaredConstructor().newInstance();

                        PlayerWarrior player = RpgAdminStateMachine.getAdminPlayer();

                        Inventory inventory = player.getInventory();

                        System.out.println("How many of this item do you want to add?");
                        System.out.print("Amount: ");

                        int itemAmount;

                        try {
                            itemAmount = RpgGame.getInput().nextInt();
                            System.out.println();

                        } catch (InputMismatchException exc) {
                            RpgGame.getInput().nextLine();
                            System.out.println("Invalid Input");
                            continue;
                        }

                        newItem.setPlayerOwner(player);
                        inventory.addItem(newItem, itemAmount);

                    } catch (ClassNotFoundException e) {

                        System.out.println("Status: Class Not Found");
                        System.out.println();
                        continue;

                    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException |
                             InstantiationException e) {
                        throw new RuntimeException(e);
                    }

                    break;
                }
            }else if(option == 2)
            {
                RpgAdminStateMachine.getInstance().setCurrentState(AdminState.MainMenu);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return getState().name();
    }
}
