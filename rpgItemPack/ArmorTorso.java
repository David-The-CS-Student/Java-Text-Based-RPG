
package rpgItemPack;

import rpgPlayerPack.PlayerWarrior;
import rpgEnemyPack.EnemyWarrior;
import rpgBasePack.BaseAttributes;
public class ArmorTorso extends Armor{

    public ArmorTorso(){}
    public ArmorTorso(String name){

        super(name);
    }

    public ArmorTorso(String name, String description, int price, PlayerWarrior owner){

        super(name, description, EquipType.Torso, price, owner);
    }

    public ArmorTorso(String name, String description, int price, PlayerWarrior owner, BaseAttributes attributes){

        super(name, description, EquipType.Torso, price, owner, attributes);
    }

    public ArmorTorso(String name, String description, int price,BaseAttributes attributes){

        super(name, description, EquipType.Torso, price, attributes);
    }

    public ArmorTorso(String name, String description, int price, EnemyWarrior owner){

        super(name, description,EquipType.Torso, price, owner);

    }

    public ArmorTorso (String name, String description, int price, EnemyWarrior owner, BaseAttributes attributes){

        super(name, description,EquipType.Torso, price, owner, attributes);

    }

    public ArmorTorso(ArmorTorso copy)
    {
        super(copy);
    }

    @Override
    public boolean equip() {

        if(getPlayerOwner() != null)
        {
            return getPlayerOwner().setTorsoArmor(this);

        }else if(getEnemyOwner() != null)
        {
            return getEnemyOwner().setTorsoArmor(this);
        }

        return false;
    }

    @Override
    public void unEquip() {
        if(getPlayerOwner() != null)
        {
            getPlayerOwner().setTorsoArmor(null);

        }else if(getEnemyOwner() != null)
        {
            getEnemyOwner().setTorsoArmor(null);
        }
    }


}
