
package rpgItemPack;
import rpgBasePack.BaseAttributes;
import rpgPlayerPack.PlayerWarrior;

public class Shield extends WeaponSecondary{

    public Shield(){}
    public Shield(String name){

        super(name);

    }

    public Shield(String name, String description, int price, PlayerWarrior owner){

        super(name, description, price, owner);

    }
    public Shield(String name, String description, int price, BaseAttributes attributes){

        super(name, description, price , attributes);

    }

    public Shield(String name, String description, int price, PlayerWarrior owner, BaseAttributes attributes){

        super(name, description,price , owner, attributes);

    }

    public Shield( Shield copy){
        super(copy);
    }

}
