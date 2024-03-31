package rpgItemPack;

public class Bones extends Item{


    public Bones(){

        super("Bones", "What remains from a slayed victim", 0);
        this.setStackable(true);
        this.setCount(3);
    }

    public Bones(Bones copy)
    {
        super(copy);
    }

    @Override
    public Item clone() {
        return new Bones(this);
    }
}
