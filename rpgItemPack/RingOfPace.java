package rpgItemPack;

import rpgBasePack.BaseAttributes;

public class RingOfPace extends AccessoryFinger {

    public RingOfPace(){
        super("Ring of Pace", "An enchanted ring that keep its barer heart rate stable",200,
                new BaseAttributes(0,0,0,0,0,2));
        setCount(1);
    }

    public RingOfPace(RingOfPace copy)
    {
        super(copy);
        setCount(copy.getCount());
    }

    @Override
    public Item clone() {
        return new RingOfPace(this);
    }
}


