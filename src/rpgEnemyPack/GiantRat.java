
package rpgEnemyPack;
import rpgBasePack.BaseAttributes;
import rpgItemPack.*;

import java.util.Random;

public class GiantRat extends EnemyCharacter{


    public GiantRat(){

        super("Giant Rat", 5, null,
                new BaseAttributes(0.0, 1.0, 0.0, 2.0, 1.0, 2.0) );
        setLevel(1);

        setExperience(9);

        setDropItems(4);

        Item bones = new Bones();

        Item moldyCheese = new MoldyCheese();
        Item freshCheese = new FreshCheese();
        Item giantRatPelt = new GiantRatPelt();

        addDropItems(bones);
        addDropItems(moldyCheese);
        addDropItems(freshCheese);
        addDropItems(giantRatPelt);

    }

    @Override
    public Item drop() {

        Random rnd = new Random();

        int randomInt = rnd.nextInt(100);

        if(randomInt < 45)
        {
            return getDropItem(0);

        }else if(randomInt >= 45 && randomInt < 65 )
        {
            return getDropItem(1);
        }
        else if(randomInt >= 65 && randomInt < 80)
        {
            return getDropItem(2);
        }else if(randomInt >= 80)
        {

            return getDropItem(3);
        }

        return null;
    }

}
