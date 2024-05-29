package rpgPlayerPack;

import rpgItemPack.Sword;
import rpgItemPack.Shield;
import rpgItemPack.WeaponPrimary;
import rpgItemPack.WeaponSecondary;

import rpgBasePack.BaseAttributes;


public class PlayerSwordsman extends PlayerWarrior {


    public PlayerSwordsman(){super();}

    public PlayerSwordsman(String name){

        super(name, new BaseAttributes(0.0,3.0,0.0, 3.0,1.0, 3.0));

    }

    public PlayerSwordsman (PlayerSwordsman copy){
        super(copy);
    }

    public Sword getSword()
    {
        if(getPrimaryWeapon() instanceof Sword)
        {
            return (Sword)getPrimaryWeapon();
        }

        return null;
    }

    @Override
    public boolean setPrimaryWeapon(WeaponPrimary primaryWeapon) {

        if(primaryWeapon instanceof Sword || primaryWeapon == null) {
            return super.setPrimaryWeapon(primaryWeapon);
        }else{
            System.out.println("Swordsman can only use swords as a primary weapon");
            return false;
        }
    }


    public Shield getShield()
    {
        if(getSecondaryWeapon() instanceof  Shield)
        {
            return (Shield) getSecondaryWeapon();
        }

        return null;
    }


    @Override
    public boolean setSecondaryWeapon(WeaponSecondary secondaryWeapon) {

        if(secondaryWeapon instanceof Shield || secondaryWeapon == null) {
            return super.setSecondaryWeapon(secondaryWeapon);
        }else{
            System.out.println("Swordsman can only use shields as a secondary weapon");
            return false;
        }

    }

    public PlayerSwordsman clone(){

        return new PlayerSwordsman(this);
    }


}
