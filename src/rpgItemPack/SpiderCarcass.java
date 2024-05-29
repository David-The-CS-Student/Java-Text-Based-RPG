package rpgItemPack;

public class SpiderCarcass extends Item {


    public SpiderCarcass(){
        super("Spider carcass", "What remains from a slayed spider", 0);
        setCount(1);
    }

    public SpiderCarcass(SpiderCarcass copy){
        super(copy);
        setCount(copy.getCount());
    }

    @Override
    public Item clone() {
        return new SpiderCarcass(this);
    }
}
