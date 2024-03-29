package rpgItemPack;

import rpgBasePack.BaseAttributes;
import rpgEnemyPack.EnemyWarrior;
import rpgPlayerPack.PlayerWarrior;

public class SatinFootWraps extends ArmorFeet{


    public SatinFootWraps(){

        super("Satin Foot Wraps", "Foot wraps made of satin", 25,
                new BaseAttributes(0,0,0,1, 1,0));

        setCount(1);

    }

    public SatinFootWraps(PlayerWarrior owner){
        super("Satin Foot Wraps", "Foot wraps made of satin", 25, owner,
                new BaseAttributes(0,0,0,1, 1,0));
        setCount(1);
    }


    public SatinFootWraps(EnemyWarrior owner){

        super("satin Foot Wraps", "Foot wraps made of satin", 25, owner,
                new BaseAttributes(0,0,0,1, 1,0));
        setCount(1);
    }


    public SatinFootWraps(SatinFootWraps copy)
    {
        super(copy);
        setCount(copy.getCount());
    }


    @Override
    public Item clone() {
        return new SatinFootWraps(this);
    }


}
