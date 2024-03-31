
package rpgItemPack;

import rpgBasePack.BaseAttributes;
import rpgPlayerPack.PlayerSwordsman;
public class Sword extends WeaponPrimary{

    public Sword(){}
    public Sword(String name){

        super(name);

    }

    public Sword(String name, String description, int price, PlayerSwordsman owner){

        super(name, description, price, owner);

    }

    public Sword(String name, String description, int price, BaseAttributes attributes){

        super(name, description,price , attributes);

    }
    public Sword(String name, String description, int price, PlayerSwordsman owner, BaseAttributes attributes){

        super(name, description,price , owner, attributes);

    }

    public  Sword(Sword copy){
        super(copy);
    }
}
