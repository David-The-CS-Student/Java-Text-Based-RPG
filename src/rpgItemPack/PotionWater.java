package rpgItemPack;

import rpgEnemyPack.EnemyCharacter;
import rpgPlayerPack.PlayerWarrior;

public final class PotionWater extends Consumable {

    public PotionWater(){

        super("Water","A simple beverage", 1, 1.0);
        setCount(1);
    }

    public PotionWater(PotionWater copy)
    {
        super(copy);
        setCount(copy.getCount());
    }

    @Override
    public Item clone() {
        return new PotionWater(this);
    }
}
