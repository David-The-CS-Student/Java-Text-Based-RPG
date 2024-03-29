package rpgItemPack;
import rpgBasePack.BaseAttributes;
import rpgEnemyPack.EnemyWarrior;
import rpgPlayerPack.PlayerWarrior;
public class IronChainMail extends ArmorTorso {



    public IronChainMail(){
        super("Iron Chain Mail", "A suit made with iron chain mail", 40,
            new BaseAttributes(0,0,0,2, 1,-1));

        setCount(1);
    }

    public IronChainMail(PlayerWarrior owner){
        super("Iron Chain Mail", "A suit made with iron chain mail", 40, owner,
                new BaseAttributes(0,0,0,2, 1,-1));

        setCount(1);
    }


    public IronChainMail(EnemyWarrior owner){

        super("Iron Chain Mail Coif", "A suit made with iron chain mail", 40, owner,
                new BaseAttributes(0,0,0,3, 1,-1));

        setCount(1);

    }

    public IronChainMail(IronChainMail copy)
    {
        super(copy);
        setCount(copy.getCount());
    }

    @Override
    public Item clone() {
        return new IronChainMail(this);
    }
}
