
package rpgEnemyPack;
import java.util.Random;
import generics.Array;
import rpgBasePack.RpgCalculator;
import rpgBasePack.RpgCharacter;
import rpgBasePack.BaseAttributes;
import rpgPlayerPack.PlayerWarrior;
import rpgBasePack.Inventory;
import rpgItemPack.Item;
//import rpgItemPack.
public class EnemyCharacter extends RpgCharacter {


    private BaseAttributes attributes;

    public double totalVitalityPoints = 0;
    public double totalAttackPoints = 0;
    public double totalMagicPoints = 0;
    public double totalDefencePoints = 0;
    public double totalMagicDefencePoints = 0;
    public double totalSpeedPoints = 0;

    private Array<Item> dropItems = null;

    private Item currentDrop = null;
    public EnemyCharacter(){super();}
    public EnemyCharacter(String name, double baseHealth){

        super(name, baseHealth);

    }

    public EnemyCharacter(String name, double baseHealth, Inventory inventory){
        super(name,baseHealth,inventory);


    }
    public EnemyCharacter(String name, double baseHealth, Inventory inventory, BaseAttributes attributes){
        super(name, baseHealth,inventory);

        this.attributes = attributes;

        this.totalAttackPoints += this.attributes.getAttack();

        this.totalMagicPoints += this.attributes.getMagic();

        this.totalDefencePoints += this.attributes.getDefence();

        this.totalMagicDefencePoints += this.attributes.getMagicDefence();

        this.totalSpeedPoints += this.attributes.getSpeed();

    }


    public BaseAttributes getAttributes() {
        return this.attributes;
    }

    public void setAttributes(BaseAttributes attributes) {
        this.attributes = attributes;
    }

    public Item[] getDropItems() {

        Item[] result = new Item[dropItems.getCount()];

        for(int index = 0; index < dropItems.getCount(); index++)
        {
            result[index] = dropItems.getObject(index);
        }

        return result;



    }

    public void setCurrentDrop(Item currentDrop){

        this.currentDrop = currentDrop;
    }

    public Item getCurrentDrop() {
        return this.currentDrop;
    }

    public  Item getDropItem(int index){

        return  dropItems.getObject(index);
    }

    public void addDropItems(Item newItem)
    {
        dropItems.add(newItem);
    }

    public void setDropItems(int size){

        dropItems = new Array<>(size);
    }
    public void attack(PlayerWarrior playerWarrior)
    {
        double enemyDamage = RpgCalculator.physicalDamageCalculator(this, playerWarrior);

        double playerHealth = playerWarrior.getHealth() - enemyDamage;

        playerWarrior.setHealth(playerHealth);

        System.out.println(this.getName() + " deals " + enemyDamage + " damage");

        if(playerWarrior.getHealth() < 0) {

            playerWarrior.setHealth(0);

        }
    }

    public Item drop(){

        Random rnd = new Random();
        int randomInt = rnd.nextInt(dropItems.getCount());


        return dropItems.getObject(randomInt);



    }

    public static void main(String[] args){



    }


}
