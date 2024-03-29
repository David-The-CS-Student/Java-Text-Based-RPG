
package rpgItemPack;

import rpgEnemyPack.EnemyWarrior;
import rpgPlayerPack.PlayerWarrior;
import rpgBasePack.BaseAttributes;
public class ArmorHead extends Armor{

    public ArmorHead(){


    }
    public ArmorHead(String name){

        super(name);
    }

    public ArmorHead(String name, String description, int price, PlayerWarrior owner){

        super(name, description, EquipType.Head, price, owner);
    }

    public ArmorHead(String name, String description, int price, PlayerWarrior owner, BaseAttributes attributes){

        super(name, description, EquipType.Head, price, owner, attributes);
    }

    public ArmorHead(String name, String description, int price, BaseAttributes attributes){

        super(name, description, EquipType.Head, price,  attributes);
    }

    public ArmorHead(String name, String description, int price, EnemyWarrior owner){

        super(name, description, EquipType.Head, price, owner);

    }

    public ArmorHead (String name, String description, int price, EnemyWarrior owner, BaseAttributes attributes){

        super(name, description, EquipType.Head, price, owner, attributes);

    }

    public ArmorHead(ArmorHead copy){
        super(copy);
    }

    @Override
    public boolean equip() {

        if(getPlayerOwner() != null)
        {
            getPlayerOwner().setHeadArmor(this);
            return true;

        }else if(getEnemyOwner() != null)
        {
            getEnemyOwner().setHeadArmor(this);
            return true;
        }
      return false;
    }

    @Override
    public void unEquip() {
        if(getPlayerOwner() != null)
        {
            getPlayerOwner().setHeadArmor(null);

        }else if(getEnemyOwner() != null)
        {
            getEnemyOwner().setHeadArmor(null);
        }
    }
}
