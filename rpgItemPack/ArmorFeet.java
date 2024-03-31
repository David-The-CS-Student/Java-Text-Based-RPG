package rpgItemPack;
import rpgPlayerPack.PlayerWarrior;
import rpgEnemyPack.EnemyWarrior;
import rpgBasePack.BaseAttributes;
public class ArmorFeet extends Armor{


    public ArmorFeet(){}
    public ArmorFeet(String name){

        super(name);
    }

    public ArmorFeet(String name, String description, int price, PlayerWarrior owner){

        super(name, description,EquipType.Feet, price, owner);
    }

    public ArmorFeet(String name, String description, int price, PlayerWarrior owner, BaseAttributes attributes){

        super(name, description, EquipType.Feet, price, owner, attributes);
    }

    public ArmorFeet(String name, String description, int price, BaseAttributes attributes){

        super(name, description, EquipType.Feet, price, attributes);
    }

    public ArmorFeet(String name, String description, int price, EnemyWarrior owner){

        super(name, description, EquipType.Feet, price, owner);

    }

    public ArmorFeet (String name, String description, int price, EnemyWarrior owner, BaseAttributes attributes){

        super(name, description, EquipType.Feet, price, owner, attributes);

    }

    public ArmorFeet(ArmorFeet copy){
        super(copy);
    }


    @Override
    public boolean equip() {

        if(getPlayerOwner()!= null)
        {
            return getPlayerOwner().setFeetArmor(this);
           
        }else if(getEnemyOwner() != null)
        {
           return getEnemyOwner().setFeetArmor(this);
           
        }

        return false;
    }


    @Override
    public void unEquip() {
        if(getPlayerOwner()!= null)
        {
            getPlayerOwner().setFeetArmor(null);

        }else if(getEnemyOwner() != null)
        {
            getEnemyOwner().setFeetArmor(null);
        }
    }
}
