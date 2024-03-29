package rpgItemPack;

import rpgEnemyPack.EnemyCharacter;
import rpgPlayerPack.PlayerWarrior;

public class FreshCheese extends Consumable{


   public FreshCheese(){

        super("Fresh Cheese", "Delicious cheese", 1, 2);

        setCount(1);
    }


    public FreshCheese(FreshCheese copy)
    {
        super(copy);
        setCount(copy.getCount());
    }

    @Override
    public Item clone() {
        return new FreshCheese(this);
    }
}
