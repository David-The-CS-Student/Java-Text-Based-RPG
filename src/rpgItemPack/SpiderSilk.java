package rpgItemPack;

public class SpiderSilk extends Item{


    public SpiderSilk(){

        super("Spider Silk", "Silk from a spider", 6);
        setCount(1);
    }


    public SpiderSilk(SpiderSilk copy){

        super(copy);
        setCount(copy.getCount());
    }

    @Override
    public Item clone() {
        return new SpiderSilk(this);
    }
}
