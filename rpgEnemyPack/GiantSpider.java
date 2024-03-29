
package rpgEnemyPack;

import java.util.Random;
import rpgBasePack.BaseAttributes;
import rpgItemPack.Item;
import rpgItemPack.SpiderCarcass;
import rpgItemPack.SpiderSilk;
import rpgItemPack.SpiderVenom;

public class GiantSpider extends EnemyCharacter {



    public GiantSpider() {

        super("Giant Spider", 5, null,
                new BaseAttributes(0.0, 1.0, 0.0, 1.0, 1.0, 3.0) );

        setLevel(1);

        setExperience(8);

        setDropItems(3);

        Item carcass = new SpiderCarcass();
        Item venom = new SpiderVenom();
        Item silk = new SpiderSilk();


        addDropItems(carcass);
        addDropItems(silk);
        addDropItems(venom);

    }


    @Override
    public Item drop() {

        Random rnd = new Random();

        int randomInt = rnd.nextInt(100);

        if(randomInt < 50)
        {
            return getDropItem(0);

        }else if(randomInt >= 50 && randomInt < 85 )
        {
            return getDropItem(1);
        }
        else if(randomInt >= 85 && randomInt < 99)
        {
            return getDropItem(2);
        }

         return null;
    }

}
