package rpgItemPack;
import rpgBasePack.BaseAttributes;
import rpgPlayerPack.PlayerWarrior;

public class WeaponSecondary extends Weapon{

    public WeaponSecondary(){}
    public WeaponSecondary(String name){

        super(name);

    }

    public WeaponSecondary(String name, String description, int price, PlayerWarrior owner){

        super(name, description, EquipType.Secondary_Weapon, price, owner);

    }

    public WeaponSecondary(String name, String description, int price, BaseAttributes attributes){

        super(name, description, EquipType.Secondary_Weapon,  price, attributes);

    }

    public WeaponSecondary(String name, String description, int price, PlayerWarrior owner, BaseAttributes attributes){

        super(name, description, EquipType.Secondary_Weapon,  price, owner, attributes);

    }

    public WeaponSecondary(WeaponSecondary copy){
        super(copy);
    }


    @Override
    public boolean equip() {
        if(getPlayerOwner() != null) {

            return getPlayerOwner().setSecondaryWeapon(this);

        }else if(getEnemyOwner() != null)
        {
            return getEnemyOwner().setSecondaryWeapon(this);
        }

        return false;
    }

    @Override
    public void unEquip() {

        if(getPlayerOwner() != null) {
            getPlayerOwner().setSecondaryWeapon(null);
        }else if(getEnemyOwner() != null)
        {
            getEnemyOwner().setSecondaryWeapon(null);
        }
    }
}
