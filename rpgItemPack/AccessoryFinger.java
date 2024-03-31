package rpgItemPack;

import rpgBasePack.BaseAttributes;
import rpgEnemyPack.EnemyWarrior;
import rpgPlayerPack.PlayerWarrior;

public abstract class AccessoryFinger extends Accessory{


    public AccessoryFinger(){

        super();

    }

    public AccessoryFinger(String name, String description, int price, BaseAttributes attr){

        super(name, description, EquipType.Finger, price, attr);
    }

    public AccessoryFinger(String name, String description, int price, BaseAttributes attr, PlayerWarrior owner){

        super(name, description, EquipType.Finger, price, attr, owner);

    }

    public AccessoryFinger(String name, String description, int price, BaseAttributes attr, EnemyWarrior owner)
    {
        super(name, description,EquipType.Finger, price, attr, owner);

    }

    public AccessoryFinger(AccessoryFinger copy){

        super(copy);

    }

    @Override
    public boolean equip() {

        if(getPlayerOwner() != null)
        {
           return getPlayerOwner().setFingerAccessory(this);
        }else if(getEnemyOwner() != null)
        {
            return getEnemyOwner().setFingerAccessory(this);
        }

        return false;
    }

    @Override
    public void unEquip() {

        if(getPlayerOwner() != null)
        {
            getPlayerOwner().setFingerAccessory(null);

        }else if(getEnemyOwner() != null)
        {
            getEnemyOwner().setFingerAccessory(null);
        }
    }
}
