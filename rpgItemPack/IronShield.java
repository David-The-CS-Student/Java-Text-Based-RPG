
package rpgItemPack;
import rpgBasePack.BaseAttributes;
import rpgPlayerPack.PlayerWarrior;
public class IronShield extends Shield{

    public IronShield(){

        super("Iron Shield","A sword made of iron.",50,
                new BaseAttributes(0, 0,0, 2,1,-1));

    }
    public IronShield(PlayerWarrior owner){

        super("Iron Shield", "A sword made of iron.",50 , owner,
                new BaseAttributes(0, 0,0, 2,1,-1));

    }

    public IronShield(IronShield copy)
    {
        super(copy);
    }

    @Override
    public Item clone() {
        return new IronShield(this);
    }
}
