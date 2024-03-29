package rpgPlayerPack;
import rpgBasePack.Equipment;
import rpgItemPack.*;
import rpgItemPack.Armor.*;
import mainApp.RpgGame;

import java.util.InputMismatchException;
import java.util.Scanner;
public class PlayerEquipment extends Equipment {

    private final Scanner input = new Scanner(System.in);

    private PlayerWarrior currentPlayer;
    public PlayerEquipment() {

        super();
    }

    public PlayerEquipment(PlayerEquipment copy)
    {
        super(copy);
    }

    public PlayerWarrior getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void setCurrentPlayer(PlayerWarrior currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void use() {

        while (true) {

            displayItems();

            System.out.println((getCount() + 1) + ". Back");
            System.out.print("select an item to inspect using its corresponding number: ");

            int itemChoice = 0;

            try{
                itemChoice = input.nextInt();
            }
            catch(InputMismatchException exc)
            {
                input.nextLine();
                continue;
            }

            if (itemChoice == (getCount() + 1)) {
                System.out.println();
                break;
            }

            if ((itemChoice - 1) < getCount()) {

                Item item = getItem(itemChoice - 1);

                while (item instanceof IEquipable equipable) {

                    System.out.println("Selected Item: " + item.getName());

                    System.out.println("1. Unequip");
                    System.out.println("2. Back");

                    System.out.print("Select the following option with its corresponding number: ");

                    int optionChoice;

                    try{

                        optionChoice = input.nextInt();

                    }catch(InputMismatchException exc)
                    {
                        input.nextLine();
                        continue;
                    }

                    if (optionChoice == 1) {

                        equipable.unEquip();

                        removeItem(item.getId());

                       this.currentPlayer.getPlayerInventory().addItem(item);

                        System.out.println();
                        break;

                    }  else if (optionChoice == 2) {
                        System.out.println();
                        break;
                    }

                    System.out.println();

                }



            }

        }


    }

}