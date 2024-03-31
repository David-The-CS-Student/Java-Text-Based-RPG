package rpgItemPack;
import rpgBasePack.BaseAttributes;
import rpgEnemyPack.EnemyWarrior;
import rpgPlayerPack.PlayerWarrior;
public class IronChainMailCoif extends ArmorHead {

    public IronChainMailCoif(){

        super("Iron Chain Mail Coif", "A coif made with iron chain mail", 25,
                new BaseAttributes(0,0,0,2, 1,0));

        setCount(1);
    }

    public IronChainMailCoif(PlayerWarrior owner){
        super("Iron Chain Mail Coif", "A coif made with iron chain mail", 25, owner,
                new BaseAttributes(0,0,0,2, 1,0));

        setCount(1);
    }


    public IronChainMailCoif (EnemyWarrior owner){

        super("Iron Chain Mail Coif", "A coif made with iron chain mail", 25, owner,
                new BaseAttributes(0,0,0,2, 1,0));
          setCount(1);
    }

    public IronChainMailCoif(IronChainMailCoif copy)
    {
        super(copy);
        setCount(copy.getCount());
    }

    @Override
    public Item clone() {
        return new IronChainMailCoif(this);
    }
}
