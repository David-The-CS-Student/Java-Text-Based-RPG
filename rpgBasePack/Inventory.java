package rpgBasePack;
import generics.Array;
import rpgItemPack.Item;
public class Inventory {



    private final Item[] items;

    Array<Item.ItemView> itemViews;
    private int count = 0;


    //no,  no - argument constructor all inventories must have a size;
    public Inventory(int size)
    {

        items = new Item[size];
        itemViews = new Array<>(size);
    }

    public Inventory(Inventory copy)
    {
        this.items = new Item[copy.getCapacity()];
        this.itemViews = new Array<>(copy.getCapacity());
        for(int itemIndex = 0; itemIndex < copy.getCount(); itemIndex++)
        {
            Item item = copy.getItem(itemIndex);
            this.addItem(item.clone());
        }
    }


    public Item getItem(int index)
    {
        //exception handling if index is out of range
        try {

            return items[index];

        }catch (ArrayIndexOutOfBoundsException err)
        {
           System.out.println(err.getMessage());
           System.out.println("The method getItem returns null");
        }

        return null;
    }


    public Item getItem(String name)
    {

        for(Item item : items) {

            if(item.getName().equals(name)) {
                return item;
            }
        }

        return null;
    }


    public void setItem(int index, Item newItem)
    {
        try {

            items[index] = newItem;
            items[index].setId(index);

        }catch (ArrayIndexOutOfBoundsException err)
        {
            System.out.println(err.getMessage());

        }
    }

    public Array<Item.ItemView> getItemViews() {
        return this.itemViews;
    }


    public Item.ItemView getGetItemView(int index) {
        return getItemViews().getObject(index);
    }

    public void addItem(Item newItem)
    {
        //try catch for exception handling if count is out of length
        try{

            if(newItem.isStackable()) {
                for (Item item : items) {

                    if (newItem.equals(item)) {

                        int newCount = item.getCount() + newItem.getCount();

                        item.setCount(newCount);

                        return;
                    }

                }
            }

            System.out.println(newItem.getName() + " has been added to " + this.getClass().getSimpleName());
            System.out.println();

            items[count] = newItem;


            items[count].setId(count);


            itemViews.add(new Item.ItemView(items[count]));
            count++;

        }catch(ArrayIndexOutOfBoundsException err){

            System.out.println(err.getMessage());

        }
    }

    public void addItem(Item newItem, int amount) {

        //try catch for exception handling if count is out of length
            try {

                if (newItem.isStackable()) {

                    if(this.count > 0) {
                        for (int itemIndex = 0; itemIndex < this.getCount(); itemIndex++) {

                            if (newItem.equals(this.items[itemIndex])) {

                                int newCount = this.items[itemIndex].getCount() + (amount* newItem.getCount());

                                this.items[itemIndex].setCount(newCount);

                                System.out.println((amount * newItem.getCount()) + " " + newItem.getName() + " has been added to " + this.getClass().getSimpleName());
                                System.out.println();

                                return;

                            } else {

                                System.out.println((amount * newItem.getCount()) + " " + newItem.getName() + " has been added to " + this.getClass().getSimpleName());

                                System.out.println();


                                items[count] = newItem;

                                items[count].setId(count);

                                items[count].setCount(amount * newItem.getCount());

                                itemViews.add(new Item.ItemView(items[count]));

                                count++;

                                return;
                            }

                        }
                    }else {

                        System.out.println((amount * newItem.getCount()) + " " + newItem.getName() + " has been added to " + this.getClass().getSimpleName());

                        System.out.println();


                        items[count] = newItem;

                        items[count].setId(count);

                        items[count].setCount(amount * newItem.getCount());

                        itemViews.add(new Item.ItemView(items[count]));

                        count++;
                    }
                }else {


                    for(int itemAmount = 0; itemAmount < amount; itemAmount++) {
                        System.out.println("1 " + newItem.getName() + " has been added to " + this.getClass().getSimpleName());

                        System.out.println();


                        items[count] = newItem;

                        items[count].setId(count);

                        itemViews.add(new Item.ItemView(items[count]));

                        count++;
                    }
                }
        }catch(ArrayIndexOutOfBoundsException err){

            System.out.println(err.getMessage());

        }

    }

    //remove item at index
    public void removeItem(int index){


        if(index < count) {

            if(items[index].isStackable()) {
                if (items[index].getCount() == 1) {
                    for (int itemIndex = index; itemIndex < count - 1; itemIndex++) {

                        items[itemIndex] = items[itemIndex + 1];

                        items[itemIndex].setId(itemIndex);
                    }

                    itemViews.remove(index);

                    count--;
                }else{

                    int newCount = items[index].getCount() -1;

                    items[index].setCount(newCount);
                }
            }
            else{


                for (int itemIndex = index; itemIndex < count - 1; itemIndex++) {

                    items[itemIndex] = items[itemIndex + 1];

                    items[itemIndex].setId(itemIndex);
                }

                itemViews.remove(index);

                count--;
            }


        }else{

            System.out.println("Index " + index + " out of range. Array length is " + items.length);
        }

    }

    public void removeItem(int index, int amount){


        if(index < count) {

            if(items[index].isStackable()) {
                if(amount <= items[index].getCount()) {

                    int newCount = items[index].getCount() - amount;

                    if (newCount == 0) {
                        for (int itemIndex = index; itemIndex < count - 1; itemIndex++) {


                            this.items[itemIndex] = this.items[itemIndex + 1];

                            this.items[itemIndex].setId(itemIndex);

                        }

                        itemViews.remove(index);
                        count--;
                    } else {

                        items[index].setCount(newCount);

                    }

                }
            }
            else{


                for (int itemIndex = index; itemIndex < count - 1; itemIndex++) {

                    items[itemIndex] = items[itemIndex + 1];

                    items[itemIndex].setId(itemIndex);
                }

                itemViews.remove(index);
                count--;
            }


        }else{

            System.out.println("Index " + index + " out of range. Array length is " + items.length);
        }

    }


    public Item[] getItems() {
        return this.items;
    }

    public int getCount() {
        return count;
    }

    public int getCapacity()
    {
        return items.length;
    }

    public void displayItems()
    {
        System.out.println("- Items in " + this.getClass().getSimpleName());
        if(this.count > 0) {

            for (int itemIndex = 0; itemIndex < count; itemIndex++) {


                System.out.println( (itemIndex+1)+ ". " + items[itemIndex]);
            }

        }else{

            System.out.println("  none");
        }
    }

    public void displayItemViews(){

        for(int viewIndex = 0; viewIndex < itemViews.getCount(); viewIndex++)
        {
            System.out.print((viewIndex + 1) + ".");
            itemViews.getObject(viewIndex).displayItemInfo();
        }
    }


    @Override
    public String toString(){
        return "this - " + this.getClass().getSimpleName() + "\n"
                +" A inventory with a size of " + items.length +
                " | This inventory currently has " + count + " items";
    }


}
