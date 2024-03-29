
package rpgItemPack;
import rpgBasePack.BaseAttributes;
import rpgPlayerPack.PlayerWarrior;

public class WeaponPrimary extends Weapon{

    public WeaponPrimary(){}
    public WeaponPrimary(String name){

        super(name);

    }

    public WeaponPrimary(String name, String description, int price, PlayerWarrior owner){

        super(name, description, EquipType.Primary_Weapon, price, owner);

    }

    public WeaponPrimary(String name, String description, int price, BaseAttributes attributes){

        super(name, description, EquipType.Primary_Weapon, price , attributes);

    }

    public WeaponPrimary(String name, String description, int price, PlayerWarrior owner, BaseAttributes attributes){

        super(name, description, EquipType.Primary_Weapon, price , owner, attributes);

    }

    public WeaponPrimary(WeaponPrimary copy){
        super(copy);
    }


    @Override
    public boolean equip() {

            if (getPlayerOwner() != null) {
                return getPlayerOwner().setPrimaryWeapon(this);
            } else if (getEnemyOwner() != null) {
               return getEnemyOwner().setPrimaryWeapon(this);
            }
        return false;
    }

    @Override
    public void unEquip() {

        if (getPlayerOwner() != null) {
            getPlayerOwner().setPrimaryWeapon(null);
        } else if (getEnemyOwner() != null) {
            getEnemyOwner().setPrimaryWeapon(null);
        }
    }
}
