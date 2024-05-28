package rpgItemPack;

import rpgEnemyPack.EnemyCharacter;
import rpgPlayerPack.PlayerWarrior;

public abstract class Consumable extends Item implements IUsable {

    private final double consumableValue;

    public Consumable(){
        super();
        this.consumableValue = 0;
    }

    public Consumable(String name, double value){

        super(name);
        this.consumableValue = value;
    }

    public Consumable(String name, String description, int price, double value){
        super(name,description, price);
        this.consumableValue = value;
    }

    public Consumable(Consumable copy){

        super(copy);
        this.consumableValue = copy.consumableValue;
    }

    public double getConsumableValue(){
        return this.consumableValue;
    }

    @Override
    public void use(PlayerWarrior player)
    {

        double newHealth = player.getHealth() + getConsumableValue();

        if(newHealth > player.getMaxHealth()) {

            System.out.println();
            System.out.println(player.getName() + "'s health has been fully restored");
            System.out.println();
            player.setHealth(player.getMaxHealth());
            return;
        }

        System.out.println();
        System.out.println(player.getName() + " restored " + getConsumableValue() + " health points");
        System.out.println();
        player.setHealth(newHealth);
    }

    @Override
    public void use(EnemyCharacter enemy) {

        double newHealth = enemy.getHealth() + getConsumableValue();

        if(newHealth > enemy.getMaxHealth())
        {
            System.out.println();
            System.out.println(enemy.getName() + "'s health has been fully restored");
            enemy.setHealth(enemy.getMaxHealth());
            return;
        }

        System.out.println();
        System.out.println(enemy.getName() + " restored " + getConsumableValue() + " health points");
        enemy.setHealth(newHealth);
    }


}
