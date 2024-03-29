package rpgItemPack;

import rpgEnemyPack.EnemyWarrior;
import rpgPlayerPack.PlayerWarrior;

public class Item {

    public static class ItemView{

        private Item item;

        public ItemView(Item item){

            this.item = item;
        }


        public Item getItem() {
            return this.item;
        }

        public void displayItemInfo(){


           System.out.println("Item Name: "+ item.getName() +" | " + "Price: "+ item.getPrice());
        }


    }

    private String name;
    private int id;
    private String description;

    private ItemView itemView;

    private int price;

    private PlayerWarrior playerOwner = null;

    private EnemyWarrior enemyOwner = null;

    private boolean stackable = false;
    private int count;
    private boolean obtained;

    public Item(){
        this.name = "N/A";
        this.description = "N/A";
        this.price = 0;
    }


    public Item(String name){

        this.name = name;
        this.description = "N/A";
        this.price = 0;
    }

    public Item(String name, String description, int price)
    {
        this.name = name;
        this.description = description;
        this.price = price;

    }

    public Item(Item copy){

        this.name = copy.getName();
        this.description = copy.getDescription();
        this.price = copy.getPrice();
        this.stackable = copy.isStackable();
        this.count = copy.count;

    }
    public String getName(){
        return this.name;
    }
    public void setName( String newName){
        this.name = newName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String newDescription)
    {

        this.description = newDescription;
    }

    public int getPrice()
    {
        return this.price;
    }

    public void setPrice(int newPrice)
    {
        this.price = newPrice;
    }


    public PlayerWarrior getPlayerOwner() {
        return playerOwner;
    }


    public void setPlayerOwner(PlayerWarrior playerOwner) {
        if(this.enemyOwner == null) {
            this.playerOwner = playerOwner;
        }
    }

    public EnemyWarrior getEnemyOwner() {
        return this.enemyOwner;
    }

    public void setEnemyOwner(EnemyWarrior enemyOwner) {
        if(this.playerOwner == null) {
            this.enemyOwner = enemyOwner;
        }
    }
    public boolean isStackable()
    {
        return this.stackable;
    }

    public void setStackable(boolean condition) {
        this.stackable = condition;
    }

    public int getCount(){
        return this.count;
    }

    public void setCount(int newAmount)
    {
        this.count = newAmount;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public ItemView getItemView(){
        return this.itemView;
    }

    public void setItemView(ItemView itemView){
        this.itemView = itemView;
    }
    public boolean isObtained(){
        return this.obtained;
    }

    public void setObtained(boolean obtained) {
        this.obtained = obtained;
    }


    public Item clone(){

        return new Item(this);
    }


    @Override
    public String toString(){


        return  isStackable() ?
                "Item Name: "+ this.name +" | " + "Description: "+ this.description + " | " +"Amount: " + this.count :
                "Item Name: "+ this.name +" | " + "Description: "+ this.description;
    }

    @Override
    public boolean equals(Object compare)
    {
        if(compare instanceof Item item)
        {
            return this.name.equals(item.getName());

        }
        return false;
    }

}
