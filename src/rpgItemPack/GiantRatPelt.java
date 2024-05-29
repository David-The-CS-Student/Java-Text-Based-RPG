package rpgItemPack;

public class GiantRatPelt extends Item{


    public GiantRatPelt(){

        super("Giant Rat Pelt", "A rat pelt", 4);
        setCount(1);
    }

    public GiantRatPelt(GiantRatPelt copy){
        super(copy);
        setCount(copy.getCount());
    }

    @Override
    public Item clone() {
        return new GiantRatPelt(this);
    }
}
