package rpgItemPack;

import rpgBasePack.BaseAttributes;
import rpgEnemyPack.EnemyWarrior;
import rpgPlayerPack.PlayerWarrior;

public class IronChainMailLeggings extends ArmorLegs {

    public IronChainMailLeggings(){
        super("Iron Chain Mail Leggings", "Leggings made with iron chain mail", 35,
                new BaseAttributes(0,0,0,3, 1,-1));

        setCount(1);

    }

    public IronChainMailLeggings(PlayerWarrior owner){
        super("Iron Chain Mail Leggings", "Leggings made with iron chain mail", 35, owner,
                new BaseAttributes(0,0,0,3, 1,-1));
        setCount(1);
    }


    public IronChainMailLeggings(EnemyWarrior owner){

        super("Iron Chain Mail Leggings", "Leggings made with iron chain mail", 35, owner,
                new BaseAttributes(0,0,0,3, 1,-1));
        setCount(1);
    }

    public IronChainMailLeggings(IronChainMailLeggings copy)
    {
        super(copy);
        setCount(copy.getCount());
    }

    @Override
    public Item clone() {
        return new IronChainMailLeggings(this);
    }
}
