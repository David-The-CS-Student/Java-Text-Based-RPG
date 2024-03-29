package rpgItemPack;

public class SpiderVenom extends  Item{



    public SpiderVenom(){

        super("Spider Venom", "venom from a spider", 5);
        setCount(1);
    }

    public SpiderVenom(SpiderVenom copy)
    {
        super(copy);
        setCount(copy.getCount());
    }

    @Override
    public Item clone() {
        return new SpiderVenom(this);
    }
}
