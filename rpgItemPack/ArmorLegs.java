
package rpgItemPack;

import rpgPlayerPack.PlayerWarrior;
import rpgEnemyPack.EnemyWarrior;
import rpgBasePack.BaseAttributes;
public class ArmorLegs extends Armor{


    public ArmorLegs(){}
    public ArmorLegs(String name){

        super(name);
    }

    public ArmorLegs(String name, String description, int price, PlayerWarrior owner){

        super(name, description, EquipType.Legs, price, owner);
    }

    public ArmorLegs(String name, String description, int price, PlayerWarrior owner, BaseAttributes attributes){

        super(name, description, EquipType.Legs, price, owner, attributes);
    }

    public ArmorLegs(String name, String description, int price, BaseAttributes attributes){

        super(name, description, EquipType.Legs, price, attributes);
    }

    public ArmorLegs(String name, String description, int price, EnemyWarrior owner){

        super(name, description, EquipType.Legs, price, owner);

    }

    public ArmorLegs (String name, String description, int price, EnemyWarrior owner, BaseAttributes attributes){

        super(name, description,EquipType.Legs, price, owner, attributes);

    }

    public ArmorLegs(ArmorLegs copy)
    {
        super(copy);
    }

    @Override
    public boolean equip() {

        if(getPlayerOwner() != null)
        {
            getPlayerOwner().setLegArmor(this);
            return true;
        }else if(getEnemyOwner() != null)
        {
            getEnemyOwner().setLegArmor(this);
            return true;
        }

        return false;
    }

    @Override
    public void unEquip() {
        if(getPlayerOwner() != null)
        {
            getPlayerOwner().setLegArmor(null);

        }else if(getEnemyOwner() != null)
        {
            getEnemyOwner().setLegArmor(null);
        }
    }
}
