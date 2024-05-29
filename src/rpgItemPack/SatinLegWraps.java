package rpgItemPack;

import rpgBasePack.BaseAttributes;
import rpgEnemyPack.EnemyWarrior;
import rpgPlayerPack.PlayerWarrior;

public class SatinLegWraps extends ArmorLegs {

    public SatinLegWraps(){
        super("Satin Leg Wraps", "Leg wraps made of satin", 35,
                new BaseAttributes(0,0,1,1, 2,0));

        setCount(1);

    }

    public SatinLegWraps(PlayerWarrior owner){
        super("Satin Leg Wraps", "Leg wraps made of satin", 35, owner,
                new BaseAttributes(0,0,1,1, 2,0));
        setCount(1);
    }


    public SatinLegWraps(EnemyWarrior owner){

        super("Satin Leg Wraps", "Leg wraps made of satin", 35, owner,
                new BaseAttributes(0,0,1,1, 2,0));
        setCount(1);
    }

    public SatinLegWraps(SatinLegWraps copy)
    {
        super(copy);
        setCount(copy.getCount());
    }

    @Override
    public Item clone() {
        return new SatinLegWraps(this);
    }
}
