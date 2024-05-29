package rpgItemPack;

import rpgBasePack.BaseAttributes;


public class BlessedNecklace extends  AccessoryNeck {

    public BlessedNecklace(){

        super("Blessed Necklace", "A holy necklace",150,
               new BaseAttributes(1,0,0,0,1,0));

        setCount(1);
    }

    public BlessedNecklace(BlessedNecklace copy)
    {
        super(copy);
        setCount(copy.getCount());
    }

    @Override
    public Item clone() {
        return new BlessedNecklace(this);
    }

    @Override
    public void unEquip() {
        super.unEquip();

        if(this.getPlayerOwner() != null)
        {
            if(this.getPlayerOwner().getHealth() > this.getPlayerOwner().getMaxHealth())
            {
                this.getPlayerOwner().setHealth(this.getPlayerOwner().getMaxHealth());
            }
        }else  if(this.getEnemyOwner() != null)
        {
            if(this.getEnemyOwner().getHealth() > this.getEnemyOwner().getMaxHealth())
            {
                this.getEnemyOwner().setHealth(this.getEnemyOwner().getMaxHealth());
            }
        }
    }
}
