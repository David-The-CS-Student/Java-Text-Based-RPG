package rpgItemPack;

import rpgBasePack.BaseAttributes;
import rpgEnemyPack.EnemyWarrior;
import rpgPlayerPack.PlayerWarrior;

public class SatinShawl extends ArmorHead{



    public SatinShawl(){

        super("Satin Shawl", "Shawl made of satin", 25,
                new BaseAttributes(0,0,0,1, 2,0));

        setCount(1);
    }

    public SatinShawl(PlayerWarrior owner){
        super("Satin Shawl", "Shawl made of satin", 25, owner,
                new BaseAttributes(0,0,0,1, 2,0));

        setCount(1);
    }


    public SatinShawl (EnemyWarrior owner){

        super("Satin Shawl", "Shawl made of satin", 25, owner,
                new BaseAttributes(0,0,0,1, 2,0));
        setCount(1);
    }

    public SatinShawl(SatinShawl copy)
    {
        super(copy);
        setCount(copy.getCount());
    }

    @Override
    public Item clone() {
        return new SatinShawl(this);
    }


}
