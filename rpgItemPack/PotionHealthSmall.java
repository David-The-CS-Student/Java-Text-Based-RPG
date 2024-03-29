package rpgItemPack;

import rpgEnemyPack.EnemyCharacter;
import rpgPlayerPack.PlayerWarrior;

public final class PotionHealthSmall extends Consumable {

    public PotionHealthSmall()
    {
        super("Small Health Potion","Its a weak health potion", 5, 3.0);
        setCount(1);
    }


    public PotionHealthSmall(PotionHealthSmall copy)
    {
        super(copy);
        setCount(copy.getCount());
    }

    @Override
    public Item clone() {
        return new PotionHealthSmall(this);
    }
}
