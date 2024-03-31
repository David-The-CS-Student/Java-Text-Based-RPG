package rpgItemPack;

import rpgBasePack.BaseAttributes;
import rpgPlayerPack.PlayerSwordsman;

public class Staff extends WeaponPrimary{

    public Staff(){}
    public Staff(String name){

        super(name);

    }

    public  Staff(String name, String description, int price, PlayerSwordsman owner){

        super(name, description, price, owner);

    }

    public Staff(String name, String description, int price, BaseAttributes attributes){

        super(name, description,price , attributes);

    }
    public Staff(String name, String description, int price, PlayerSwordsman owner, BaseAttributes attributes){

        super(name, description,price , owner, attributes);

    }

    public  Staff(Staff copy){
        super(copy);
    }


}
