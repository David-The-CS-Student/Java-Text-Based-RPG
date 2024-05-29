
package rpgBasePack;
import rpgItemPack.*;

public class Equipment extends Inventory{

    public Equipment(){
        super(8);
    }

    public Equipment(Equipment copy){
        super(copy);
    }

    public IEquipable getEquipable(IEquipable.EquipType  type){

        for(int itemIndex = 0; itemIndex < getCount(); itemIndex++){

            Item item = getItem(itemIndex);

            if(item instanceof IEquipable equipable)
            {
                if(equipable.getEquipType() == type) {
                    return equipable;
                }
            }
        }
        return null;
    }

    public Item getItem(IEquipable.EquipType  type){

        for(int itemIndex = 0; itemIndex < getCount(); itemIndex++){

            Item item = getItem(itemIndex);

            if(item instanceof IEquipable equipable)
            {
                if(equipable.getEquipType() == type) {
                    return item;
                }
            }
        }

        return null;
    }
}
