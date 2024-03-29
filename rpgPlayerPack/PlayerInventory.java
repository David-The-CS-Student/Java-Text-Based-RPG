

package rpgPlayerPack;
import rpgBasePack.Equipment;
import rpgBasePack.Inventory;
import rpgItemPack.*;
import mainApp.RpgGame;

import java.util.InputMismatchException;
import java.util.Scanner;
public class PlayerInventory extends Inventory {

   private final Scanner input = new Scanner(System.in);

   private PlayerWarrior currentPlayer;
   public PlayerInventory ()
   {
       super(20);

   }

   public PlayerInventory(PlayerInventory copy){

      super(copy);
   }

   public PlayerWarrior getCurrentPlayer() {
      return this.currentPlayer;
   }

   public void setCurrentPlayer(PlayerWarrior currentPlayer) {
      this.currentPlayer = currentPlayer;
   }
   @Override
   public void displayItemViews() {

      for(int viewIndex = 0; viewIndex < getItemViews().getCount(); viewIndex++)
      {
         System.out.print((viewIndex + 1) + ".");

         Item item = getItemViews().getObject(viewIndex).getItem();

         if(item.isStackable()) {
            System.out.println("Item Name: " + item.getName() + " | " + "Price: " + item.getPrice() + " | Amount: " + item.getCount());
         }else{
            getItemViews().getObject(viewIndex).displayItemInfo();
         }
      }

   }

   public void use(){


      while(true) {

         this.displayItems();

         System.out.println((getCount()+1) +". Back");
         System.out.print("select an item to inspect using its corresponding number: ");

         int itemChoice = 0;

         try {
            itemChoice = input.nextInt();

         }catch(InputMismatchException exc)
         {
            input.nextLine();
            continue;
         }
         //try catch InputMismatchException


         if(itemChoice == (getCount()+1))
         {
            System.out.println();
            break;
         }

         if((itemChoice-1) < getCount() )
         {

            Item item = getItem(itemChoice-1);

            while(item.getClass().getSuperclass().getSimpleName().equals("Item"))
            {
               System.out.println("Selected Item: "+ item.getName());

               System.out.println("1. Drop");
               System.out.println("2. Back");

               System.out.print("Select the following option with its corresponding number: ");

               int optionChoice;

               try {
                  optionChoice = input.nextInt();

               }catch(InputMismatchException exc)
               {
                  input.nextLine();
                  continue;
               }

               if(optionChoice == 1)
               {
                  //are you sure?!
                  if(item.isStackable()) {
                     this.removeItem(item.getId(), item.getCount());
                  }else{
                     this.removeItem(item.getId());
                  }
                   break;

               }
               else if(optionChoice == 2)
               {
                  System.out.println();
                   break;
               }
               System.out.println();
            }


            while (item instanceof IEquipable equipable)
            {
               System.out.println("Selected Item: "+ item.getName());

               System.out.println("1. Equip");
               System.out.println("2. Drop");
               System.out.println("3. Back");

               System.out.print("Select the following option with its corresponding number: ");

               int optionChoice;

               try{
                  optionChoice = input.nextInt();
               }catch(InputMismatchException exc)
               {
                  input.nextLine();
                  continue;
               }

               if(optionChoice == 1)
               {
                  Equipment equipment = this.currentPlayer.getEquipment();

                  if(equipment.getEquipable(equipable.getEquipType()) == null) {
                     if(equipable.equip()) {
                        this.removeItem(item.getId());

                        this.currentPlayer.getEquipment().addItem(item);
                     }
                     System.out.println();

                  }else{


                     IEquipable currentEquipable = equipment.getEquipable(equipable.getEquipType());

                     currentEquipable.unEquip();

                     if(equipable.equip()) {

                        Item equippedItem = equipment.getItem(equipable.getEquipType());

                        int itemId = item.getId();

                        equipment.setItem(equippedItem.getId(), item);

                        this.setItem(itemId, equippedItem);


                     }

                     System.out.println();

                  }

                  break;
               }
               else if(optionChoice == 2)
               {

                  this.removeItem(item.getId());
                  System.out.println();
                  break;

               }
               else if(optionChoice == 3)
               {
                  System.out.println();
                  break;

               }

               System.out.println();
            }

            while (item instanceof IUsable usable)
            {
               System.out.println("Selected Item: "+ item.getName());

               System.out.println("1. Use");
               System.out.println("2. Drop");
               System.out.println("3. Back");

               System.out.print("Select the following option with its corresponding number: ");

               int optionChoice;

               try{
                  optionChoice = input.nextInt();

               }catch(InputMismatchException exc)
               {
                  input.nextLine();
                  continue;
               }


               if(optionChoice == 1){

                  usable.use(this.currentPlayer);
                  System.out.println(item.getId());
                  this.removeItem(item.getId());
                  break;
               }
               else if(optionChoice == 2)
               {
                  //are you sure?!
                  this.removeItem(item.getId());

                  break;
               }
               else if(optionChoice == 3){

                  break;

               }


            }

         }

      }

   }


}
