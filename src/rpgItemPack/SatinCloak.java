package rpgItemPack;

import rpgBasePack.BaseAttributes;
import rpgEnemyPack.EnemyWarrior;
import rpgPlayerPack.PlayerWarrior;

public class SatinCloak extends  ArmorTorso{

    public SatinCloak(){
        super("Satin Cloak", "Cloak made of satin", 40,
                new BaseAttributes(0,0,1,1, 2,0));

        setCount(1);
    }

    public SatinCloak(PlayerWarrior owner){
        super("Satin Cloak", "Cloak made of satin", 40, owner,
                new BaseAttributes(0,0,1, 1, 2,0));

        setCount(1);
    }

    public SatinCloak(EnemyWarrior owner){

        super("Satin Cloak", "Cloak made of satin", 40, owner,
                new BaseAttributes(0,0,1,1, 2,0));

        setCount(1);

    }

    public SatinCloak(SatinCloak copy){
        super(copy);
        setCount(copy.getCount());
    }

    @Override
    public Item clone() {
        return new SatinCloak(this);
    }
}
