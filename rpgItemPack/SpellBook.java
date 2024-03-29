package rpgItemPack;

import rpgBasePack.BaseAttributes;
import rpgPlayerPack.PlayerWarrior;

public class SpellBook extends WeaponSecondary{

    public SpellBook(){}
    public SpellBook(String name){

        super(name);

    }

    public SpellBook(String name, String description, int price, PlayerWarrior owner){

        super(name, description, price, owner);

    }
    public SpellBook(String name, String description, int price, BaseAttributes attributes){

        super(name, description, price , attributes);

    }

    public SpellBook(String name, String description, int price, PlayerWarrior owner, BaseAttributes attributes){

        super(name, description,price , owner, attributes);

    }

    public SpellBook( SpellBook copy){
        super(copy);
    }

}
