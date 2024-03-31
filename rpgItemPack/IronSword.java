
package rpgItemPack;

import rpgBasePack.BaseAttributes;
import rpgPlayerPack.PlayerSwordsman;
public class IronSword extends Sword{

    public IronSword(){

        super("Iron Sword","A sword made of iron.",50,
                new BaseAttributes(0, 2,0, 1,0,-1));

    }
    public IronSword (PlayerSwordsman owner){

        super("Iron Sword", "A sword made of iron.",50 , owner,
                new BaseAttributes(0, 2,0, 1,0,-1));

    }

    public IronSword(IronSword copy){
        super(copy);
    }

    @Override
    public Item clone() {
        return new IronSword(this);
    }
}
