package rpgItemPack;

import rpgBasePack.BaseAttributes;
import rpgEnemyPack.EnemyWarrior;
import rpgPlayerPack.PlayerWarrior;

public abstract class AccessoryNeck extends Accessory {

    public AccessoryNeck(){
        super();
    }

    public AccessoryNeck(String name, String description, int price, BaseAttributes attr){
        super(name, description, EquipType.Neck, price, attr);
    }

    public AccessoryNeck(String name, String description, int price, BaseAttributes attr, PlayerWarrior owner){

        super(name, description, EquipType.Neck, price, attr, owner);

    }

    public AccessoryNeck(String name, String description, int price, BaseAttributes attr, EnemyWarrior owner){
        super(name, description,EquipType.Neck, price, attr, owner);

    }

    public AccessoryNeck(AccessoryNeck copy){
        super(copy);
    }

    @Override
    public boolean equip() {

        if(getPlayerOwner() != null)
        {
           return getPlayerOwner().setNeckAccessory(this);
        }else if(getEnemyOwner() != null)
        {
           return getEnemyOwner().setNeckAccessory(this);
        }

        return false;
    }

    @Override
    public void unEquip() {

        if(getPlayerOwner() != null)
        {
            getPlayerOwner().setNeckAccessory(null);

        }else if(getEnemyOwner() != null)
        {
            getEnemyOwner().setNeckAccessory(null);
        }
    }
}
