package rpgLocationPack;
import mainApp.RpgGame;
import rpgBasePack.Inventory;
import rpgItemPack.*;
import generics.Array;
import rpgPlayerPack.PlayerInventory;
import rpgPlayerPack.PlayerWarrior;

import java.util.InputMismatchException;

public class Bank {

    static class BankItem{


        private Item item;
        private boolean wasStackable = false;
        public BankItem(Item item){

            this.item = item;
            if(!this.item.isStackable()) {
                this.item.setStackable(true);
            }else{
                this.wasStackable = true;
            }
        }


    }
    static class BankItemView{

        public Array<BankItem> bankItems;

        public BankItemView()
        {
            bankItems = new Array<>(3);
        }

        public boolean addItem(Item item){
            if(bankItems.getCount() < bankItems.getCapacity()){

                BankItem bankItem = new BankItem(item);

                bankItems.add(bankItem);

                return true;
            }
            return false;
        }

        public boolean removeBankItem(int id){

            int index = 0;
            boolean isFound = false;
            for(int columnIndex = 0; columnIndex < bankItems.getCount(); columnIndex++){

                if(bankItems.getObject(columnIndex).item.getId() == id){
                    if(columnIndex == bankItems.getCapacity()-1)
                    {
                        bankItems.remove(columnIndex);
                        return true;
                    }


                    index = columnIndex;
                    isFound = true;
                    break;
                }
            }

            if(isFound) {
                for(int columnIndex = index+1; columnIndex < bankItems.getCount(); columnIndex++){

                    int newId = bankItems.getObject(columnIndex).item.getId()-1;

                    bankItems.getObject(columnIndex).item.setId(newId);

                }
               bankItems.remove(index);
            }

            return isFound;
        }

        public BankItem getBankItem(int id){

            for(int itemIndex = 0; itemIndex < bankItems.getCount(); itemIndex++){
                if(bankItems.getObject(itemIndex).item.getId() == id){
                    return bankItems.getObject(itemIndex);
                }
            }

            return null;
        }

        public Array<BankItem> getBankItems(){

            return bankItems;
        }
        public Item getFirst(){
            return this.bankItems.getObject(0).item;
        }

        public Item getSecond(){
            return this.bankItems.getObject(1).item;
        }

        public Item getThird(){
            return this.bankItems.getObject(2).item;
        }

        public int getCount(){

            return bankItems.getCount();
        }
        public String toString(){

            String layout = "";

            if(bankItems.getCount() == 1){
                layout = String.format("%-40s %-35s %-35s",
                        (this.getFirst().getId() ) + ". " + this.getFirst().getName() + " x" + this.getFirst().getCount(),
                        "", "");
            }
            else if(bankItems.getCount() == 2){
                layout = String.format("%-40s %-35s %-35s",
                        (this.getFirst().getId()) + ". " + this.getFirst().getName() + " x" + this.getFirst().getCount(),
                        (this.getSecond().getId()) + ". " + this.getSecond().getName() + " x" + (this.getSecond().getCount()), "");
            }
            else if(bankItems.getCount() == 3) {
                layout = String.format("%-40s %-35s %-35s",
                        (this.getFirst().getId() ) + ". " + this.getFirst().getName() + " x" + this.getFirst().getCount(),
                        (this.getSecond().getId()) + ". " + this.getSecond().getName() + " x" + (this.getSecond().getCount()),
                        (this.getThird().getId()) + ". " + this.getThird().getName() + " x" + this.getThird().getCount());
            }
            return layout;

        }

    }

    private Bank(){

        views = new Array<>(10);
    }

    private final int maxItems = 30;
    public int count;

    private static PlayerWarrior  player;

    public static PlayerWarrior getPlayer(){
        return player;
    }

    public static void setPlayer(PlayerWarrior newPlayer) {
        player = newPlayer;
    }
    private static Bank instance = null;

    public static Bank getInstance(){

        if(instance == null){

            instance = new Bank();

            return instance;
        }

        return instance;
    }

    Array<BankItemView> views;

    public Array<BankItemView> getViews(){
        return views;
    }

   public BankItem getBankItem(int id){

       for(int row = 0; row < views.getCount(); row++)
       {
           BankItemView view = views.getObject(row);

           if(view.getBankItem(id) != null) {
               return view.getBankItem(id);
           }

       }

       return null;
   }
   public boolean add(Item item)
   {
       for(int bankRow = 0; bankRow < views.getCount(); bankRow++)
       {
           BankItemView row = views.getObject(bankRow);
           for(int bankColumn = 0; bankColumn < row.bankItems.getCount(); bankColumn++)
           {
               BankItem bankItem = row.bankItems.getObject(bankColumn);
               if(item.equals(bankItem.item))
               {
                   bankItem.item.setCount(bankItem.item.getCount() +item.getCount());

                  return true;
               }
           }
       }

       if(views.getCount() != 0) {

           if(views.getCount() <= views.getCapacity()){

               for(int row = 0; row < views.getCount(); row++) {
                   if (!views.getObject(row).addItem(item)) {

                       if(row == views.getCount()-1) {
                           BankItemView bankItemView = new BankItemView();
                           bankItemView.addItem(item);
                           views.add(bankItemView);

                           if (!isFull()) {
                               count++;
                               item.setId(((row)*3) + (views.getObject(row).getCount() +1) );
                           }
                          return true;
                       }
                   } else {

                       if (!isFull()) {
                           count++;
                           item.setId((row*3) + views.getObject(row).getCount() );
                       }
                       return true;
                   }
               }
           }
       }else{

           BankItemView bankItemView = new BankItemView();

           if(!isFull()){
               count++;
               item.setId(count);
           }

           bankItemView.addItem(item);
           views.add(bankItemView);

           return true;
       }
       return false;
   }


   public BankItem remove(int id){

       for(int row = 0; row < views.getCount(); row++){

           BankItemView view = views.getObject(row);
           for(int column = 0; column< view.getCount(); column++)
           {
               BankItem bankItem = view.bankItems.getObject(column);
               if(bankItem.item.getId() == id )
               {
                   int itemCount = view.getBankItem(id).item.getCount();
                   if(itemCount > 1) {

                       view.bankItems.getObject(column).item.setCount(itemCount-1);

                   }else{

                       view.removeBankItem(id);

                       if(view.getCount() == 0){
                           views.remove(row);
                       }
                       count--;
                   }
                   return bankItem;
               }
           }
       }
       return null;
   }
   public boolean isFull()
   {
       return count == maxItems;
   }

   public String getBankData(){

        String data = "";

       for(int row = 0; row< views.getCount(); row++)
       {
          BankItemView bankView = views.getObject(row);

           for(int column = 0; column < bankView.getCount(); column++)
           {
               BankItem bankItem =  bankView.getBankItems().getObject(column);
                data +=  bankItem.item.getClass().getSimpleName() + " " + bankItem.item.getCount() + "\n";
           }
       }

       return data;

   }


   public void use(String locationName){

       System.out.println("Welcome to the " + locationName + " Bank!");

       mainLoop:
       while(true) {

           this.displayInterface();


           System.out.println("1 Store Item");
           System.out.println("2 Take Item");
           System.out.println("3 Leave");

           char choice = RpgGame.getInput().next().charAt(0);

           switch(choice)
           {
               case'1': {

                   assert  Bank.getPlayer() != null;

                   Inventory playerInventory = Bank.getPlayer().getInventory();

                   while (true) {

                       System.out.println("Select an item by is corresponding number");

                       playerInventory.displayItems();

                       int exitNumber = (playerInventory.getCount()+1);

                       System.out.println( exitNumber + " Back");

                       int itemChoice = 0;

                       try{
                           itemChoice = RpgGame.getInput().nextInt();
                       }catch(InputMismatchException exc)
                       {
                           RpgGame.getInput().nextLine();
                           continue ;
                       }

                       if(itemChoice == exitNumber) {
                           break;
                       }

                       Item inventoryItem = playerInventory.getItem(itemChoice-1);

                       try {

                           while(true) {

                               if (inventoryItem.getCount() > 1) {
                                   System.out.print("How much would you like to store?: ");

                                   int itemAmount = 0;

                                   try {
                                       itemAmount = RpgGame.getInput().nextInt();
                                   } catch (InputMismatchException exc) {
                                       RpgGame.getInput().nextLine();
                                       continue;
                                   }

                                   Item storedItem = inventoryItem.clone();

                                   storedItem.setCount(itemAmount);

                                   if(add(storedItem)) {

                                       playerInventory.removeItem(itemChoice - 1, itemAmount);

                                       break;

                                   }else{

                                       System.out.println("Bank full");
                                       break;

                                   }
                               }else{

                                   Item storedItem = inventoryItem.clone();

                                   if(add(storedItem)){

                                      playerInventory.removeItem(itemChoice-1);
                                      break;

                                   }else{
                                       System.out.println("Bank full");
                                       break;
                                   }

                               }
                           }

                       } catch (NullPointerException exc) {
                           System.out.println(exc.getMessage());
                       }
                   }

                   break;
               }
               case '2': {

                   assert Bank.getPlayer() != null;

                   Inventory playerInventory = Bank.getPlayer().getInventory();

                   while (true) {

                       System.out.println("Select an item by is corresponding number");

                       this.displayInterface();

                       System.out.println("0 Back");

                       System.out.print("Choice: ");

                       int itemChoice = 0;

                       try {
                           itemChoice = RpgGame.getInput().nextInt();
                       } catch (InputMismatchException exc) {
                           RpgGame.getInput().nextLine();
                           continue;
                       }
                       if (itemChoice == 0) {
                           break;
                       }

                       BankItem bankItem = this.getBankItem(itemChoice);

                       System.out.println();
                       try {

                          while(true)
                          {
                            if (bankItem.item.getCount() > 1) {

                               System.out.print("How much would you like to take?: ");

                               int itemAmount = 0;

                               try {

                                   itemAmount = RpgGame.getInput().nextInt();

                               } catch (InputMismatchException exc) {

                                   continue;
                               }

                               Item itemInBank = bankItem.item.clone();

                               for(int i = 0; i < itemAmount; i++)
                               {

                                   this.remove(bankItem.item.getId());

                               }

                               if (!bankItem.wasStackable) {

                                   itemInBank.setStackable(false);

                                   for(int i = 0; i < itemAmount; i++)
                                   {
                                       playerInventory.addItem(itemInBank);
                                   }

                                   break;

                               }else{
                                  
                                   itemInBank.setCount(itemAmount);
                                   playerInventory.addItem(itemInBank);
                                   break;
                               }

                           } else {

                                Item itemInBank = bankItem.item.clone();

                                this.remove(bankItem.item.getId());

                                if (!bankItem.wasStackable) {

                                    itemInBank.setStackable(false);
                                }

                                playerInventory.addItem(itemInBank);

                                break;
                           }

                         }
                       } catch (NullPointerException exc) {
                           System.out.println(exc.getMessage());

                       }
                   }
                   break;
               }
               case '3':
                   break mainLoop;
           }
       }
   }

   public void displayInterface(){

       System.out.println("-".repeat(110));
       System.out.printf("|%55s %52s|%n", "Bank", "");
       System.out.println("-".repeat(110));

       if(views.getCount() > 0) {
           for (int row = 0; row < views.getCount(); row++) {
               BankItemView view = views.getObject(row);

               System.out.println(view);
           }
       }else{
           System.out.println("-No items currently in the bank-");
       }
       System.out.println("-".repeat(110));
   }

    public static void main(String[] args) {

        for(int i = 0; i < 9; i++){
            Bank.getInstance().add(new Item("Test Item " + (i+1)));

        }

        Bank.getInstance().displayInterface();

        Bank.getInstance().remove(5);


        Bank.getInstance().displayInterface();

        Bank.getInstance().add(new Item("Test Item 10" ));

        Bank.getInstance().displayInterface();

        Bank.getInstance().add(new Item("Test Item 12" ));

        Bank.getInstance().displayInterface();

        Bank.getInstance().add(new Item("Test Item 20" ));

        Bank.getInstance().displayInterface();


        Bank.getInstance().remove(7);


        Bank.getInstance().displayInterface();

        Bank.getInstance().add(new Item("Test Item 30" ));

        Bank.getInstance().displayInterface();

        for(int i = 31; i < 34; i++)
        {
            Bank.getInstance().add(new Item("Test Item " + (i+1)));

        }

        Bank.getInstance().displayInterface();
    
    }

}
