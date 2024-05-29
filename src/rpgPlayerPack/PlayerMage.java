package rpgPlayerPack;

import rpgBasePack.BaseAttributes;
import rpgBasePack.RpgCalculator;
import rpgEnemyPack.EnemyCharacter;
import rpgItemPack.Staff;
import rpgItemPack.SpellBook;
import rpgItemPack.WeaponPrimary;
import rpgItemPack.WeaponSecondary;

public class PlayerMage extends PlayerWarrior{

    public PlayerMage(){super();}

    public PlayerMage(String name){

        super(name, new BaseAttributes(0.0,0.0,3.0, 1.0,3.0, 3.0));

    }

    public PlayerMage(PlayerMage copy)
    {
        super(copy);
    }

    public Staff getStaff()
    {
        if(getPrimaryWeapon() instanceof Staff)
        {
            return (Staff)getPrimaryWeapon();
        }

        return null;
    }

    @Override
    public boolean setPrimaryWeapon(WeaponPrimary primaryWeapon) {

        if(primaryWeapon instanceof Staff || primaryWeapon == null) {
           return super.setPrimaryWeapon(primaryWeapon);
        }else{
            System.out.println("Mage can only use staffs as a primary weapon");
            return false;
        }
    }



    public SpellBook getSpellBook()
    {
        if(getSecondaryWeapon() instanceof  SpellBook)
        {
            return (SpellBook) getSecondaryWeapon();
        }

        return null;
    }


    @Override
    public boolean setSecondaryWeapon(WeaponSecondary secondaryWeapon) {

        if(secondaryWeapon instanceof SpellBook || secondaryWeapon == null) {
            return super.setSecondaryWeapon(secondaryWeapon);
        }else{
            System.out.println("Mage can only use spell books as a secondary weapon");

            return false;
        }

    }

    @Override
    public void attack(EnemyCharacter enemyCharacter) {
        double playerDamage = RpgCalculator.magicDamageCalculator(this, enemyCharacter);

        double enemyHealth = enemyCharacter.getHealth() - playerDamage;

        enemyCharacter.setHealth(enemyHealth);

        System.out.println(this.getName() + " deals " + playerDamage + " damage");

        if(enemyCharacter.getHealth() < 0)
        {
            enemyCharacter.setHealth(0);
        }
    }

    public PlayerMage clone(){
        return new PlayerMage(this);
    }
}
