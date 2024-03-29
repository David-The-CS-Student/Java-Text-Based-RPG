package rpgItemPack;

import rpgBasePack.BaseAttributes;
import rpgEnemyPack.EnemyWarrior;
import rpgPlayerPack.PlayerWarrior;

public class IronPlateBoots extends ArmorFeet{


    public IronPlateBoots(){

        super("Iron Plate Boots", "Boots made with iron plates", 25,
                new BaseAttributes(0,0,0,1, 1,-1));

        setCount(1);

    }

    public IronPlateBoots(PlayerWarrior owner){
        super("Iron Plate Boots", "Boots made with iron plates", 25, owner,
                new BaseAttributes(0,0,0,1, 1,-1));
        setCount(1);
    }


    public IronPlateBoots(EnemyWarrior owner){

        super("Iron Plate Boots", "Boots made with iron plates", 25, owner,
                new BaseAttributes(0,0,0,1, 1,-1));
        setCount(1);
    }


    public IronPlateBoots(IronPlateBoots copy)
    {
        super(copy);
        setCount(copy.getCount());
    }


    @Override
    public Item clone() {
        return new IronPlateBoots(this);
    }
}
