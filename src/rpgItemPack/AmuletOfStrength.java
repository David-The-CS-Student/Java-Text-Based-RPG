package rpgItemPack;

import rpgBasePack.BaseAttributes;

public class AmuletOfStrength extends AccessoryNeck {

    public AmuletOfStrength(){

        super("Amulet of Strength", "An enchanted amulet that gives it barer strength",175,
                new BaseAttributes(0,2,0,0,0,0));

        setCount(1);
    }

    public AmuletOfStrength(AmuletOfStrength copy){
        super(copy);
        setCount(copy.getCount());
    }

    @Override
    public Item clone() {
        return  new AmuletOfStrength(this);
    }
}
