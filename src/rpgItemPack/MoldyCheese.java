package rpgItemPack;

import rpgEnemyPack.EnemyCharacter;
import rpgPlayerPack.PlayerWarrior;

public class MoldyCheese extends Consumable {

    public MoldyCheese(){

        super("Moldy Cheese", "Cheese gone bad", 0, -1);
        setCount(1);
    }

    public MoldyCheese(MoldyCheese copy){
        super(copy);
        setCount(copy.getCount());
    }

    @Override
    public Item clone() {
        return new MoldyCheese();
    }
}
