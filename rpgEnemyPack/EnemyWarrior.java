package rpgEnemyPack;




import rpgBasePack.BaseAttributes;
import rpgBasePack.Inventory;
import rpgItemPack.*;

public class EnemyWarrior extends EnemyCharacter {



    private WeaponPrimary primaryWeapon = null;
    private WeaponSecondary secondaryWeapon = null;
    private ArmorHead headArmor;

    private AccessoryNeck neckAccessory;
    private ArmorTorso torsoArmor;

    private AccessoryFinger fingerAccessory = null;
    private ArmorLegs legArmor;
    private ArmorFeet feetArmor;

    public EnemyWarrior(){super();}
    public EnemyWarrior(String name, double maxHealth){
        super(name, maxHealth);
    }

    public EnemyWarrior(String name, double maxHealth, Inventory inventory){
        super(name, maxHealth,inventory);

    }
    public EnemyWarrior(String name, double maxHealth, Inventory inventory, BaseAttributes attributes){
        super(name, maxHealth,inventory, attributes);


    }

    public WeaponPrimary getPrimaryWeapon() {
        return primaryWeapon;
    }

    public boolean setPrimaryWeapon(WeaponPrimary primaryWeapon)
    {
        if(this.primaryWeapon != null) {


            this.totalAttackPoints -= this.primaryWeapon.getAttackPoints();
            this.totalDefencePoints -= this.primaryWeapon.getDefencePoints();
            this.totalSpeedPoints -= this.primaryWeapon.getSpeedPoints();


            this.primaryWeapon = primaryWeapon;

            if(this.primaryWeapon != null) {

                this.totalAttackPoints += primaryWeapon.getAttackPoints();
                this.totalDefencePoints += primaryWeapon.getDefencePoints();
                this.totalSpeedPoints += primaryWeapon.getSpeedPoints();
            }

        }else{

            this.primaryWeapon = primaryWeapon;


            this.totalAttackPoints += this.primaryWeapon.getAttackPoints();
            this.totalDefencePoints += this.primaryWeapon.getDefencePoints();
            this.totalSpeedPoints += this.primaryWeapon.getSpeedPoints();




        }

        return true;
    }

    public WeaponSecondary getSecondaryWeapon() {
        return this.secondaryWeapon;
    }

    public boolean setSecondaryWeapon(WeaponSecondary secondaryWeapon) {

        if(this.secondaryWeapon != null) {


            this.totalAttackPoints -= this.secondaryWeapon.getAttackPoints();
            this.totalDefencePoints -= this.secondaryWeapon.getDefencePoints();
            this.totalSpeedPoints -= this.secondaryWeapon.getSpeedPoints();


            this.secondaryWeapon = secondaryWeapon;

            if(this.secondaryWeapon != null) {

                this.totalAttackPoints += secondaryWeapon.getAttackPoints();
                this.totalDefencePoints += secondaryWeapon.getDefencePoints();
                this.totalSpeedPoints += secondaryWeapon.getSpeedPoints();
            }

        }else{


            this.secondaryWeapon = secondaryWeapon;

            this.totalAttackPoints += this.secondaryWeapon.getAttackPoints();
            this.totalDefencePoints += this.secondaryWeapon.getDefencePoints();
            this.totalSpeedPoints += this.secondaryWeapon.getSpeedPoints();


        }

        return true;
    }

    public ArmorHead getHeadArmor() {
        return this.headArmor;
    }

    public void setHeadArmor(ArmorHead head) {
        if(this.headArmor != null) {

            totalDefencePoints -= this.headArmor.getDefencePoints();
            totalMagicDefencePoints -= this.headArmor.getMagicDefencePoints();
            totalSpeedPoints -= this.headArmor.getSpeedPoints();

            this.headArmor = head;

            if(this.headArmor != null) {
                totalDefencePoints += this.headArmor.getDefencePoints();
                totalMagicDefencePoints += this.headArmor.getMagicDefencePoints();
                totalSpeedPoints += this.headArmor.getSpeedPoints();
            }

        }else{

            this.headArmor = head;

            totalDefencePoints += this.headArmor.getDefencePoints();
            totalMagicDefencePoints += this.headArmor.getMagicDefencePoints();
            totalSpeedPoints += this.headArmor.getSpeedPoints();

        }
    }

    public AccessoryNeck getNeckAccessory(){return this.neckAccessory;}

    public boolean setNeckAccessory(AccessoryNeck neckAccessory)
    {

        if(this.neckAccessory != null)
        {

            totalVitalityPoints -= this.neckAccessory.getVitalityPoints();
            totalAttackPoints -= this.neckAccessory.getAttackPoints();
            totalMagicPoints -= this.neckAccessory.getMagicPoints();
            totalDefencePoints -= this.neckAccessory.getDefencePoints();
            totalMagicDefencePoints -= this.neckAccessory.getMagicDefencePoints();
            totalSpeedPoints -= this.neckAccessory.getSpeedPoints();

        }

        this.neckAccessory = neckAccessory;

        if(this.neckAccessory != null)
        {
            totalVitalityPoints += this.neckAccessory.getVitalityPoints();
            totalAttackPoints += this.neckAccessory.getAttackPoints();
            totalMagicPoints += this.neckAccessory.getMagicPoints();
            totalDefencePoints +=  this.neckAccessory.getDefencePoints();
            totalMagicDefencePoints += this.neckAccessory.getMagicDefencePoints();
            totalSpeedPoints += this.neckAccessory.getSpeedPoints();
        }

        return true;
    }

    public ArmorTorso getTorsoArmor() {
        return this.torsoArmor;
    }

    public void setTorsoArmor(ArmorTorso torsoArmor) {
        if(this.torsoArmor != null) {

            totalDefencePoints -= this.torsoArmor.getDefencePoints();
            totalMagicDefencePoints -= this.torsoArmor.getMagicDefencePoints();
            totalSpeedPoints -= this.torsoArmor.getSpeedPoints();

            this.torsoArmor = torsoArmor;

            if(this.torsoArmor != null) {
                totalDefencePoints += this.torsoArmor.getDefencePoints();
                totalMagicDefencePoints += this.torsoArmor.getMagicDefencePoints();
                totalSpeedPoints += this.torsoArmor.getSpeedPoints();
            }

        }else{

            this.torsoArmor = torsoArmor;

            totalDefencePoints += this.torsoArmor.getDefencePoints();
            totalMagicDefencePoints += this.torsoArmor.getMagicDefencePoints();
            totalSpeedPoints += this.torsoArmor.getSpeedPoints();

        }
    }
    public AccessoryFinger getFingerAccessory(){return this.fingerAccessory;}

    public boolean setFingerAccessory(AccessoryFinger fingerAccessory)
    {

        if(this.fingerAccessory != null)
        {

            this.totalVitalityPoints -= this.fingerAccessory.getVitalityPoints();
            this.totalAttackPoints -= this.fingerAccessory.getAttackPoints();
            this.totalMagicPoints -= this.fingerAccessory.getMagicPoints();
            this.totalDefencePoints -= this.fingerAccessory.getDefencePoints();
            this.totalMagicDefencePoints -= this.fingerAccessory.getMagicDefencePoints();
            this.totalSpeedPoints -= this.fingerAccessory.getSpeedPoints();
        }

        this.fingerAccessory = fingerAccessory;

        if(this.fingerAccessory != null)
        {
            this.totalVitalityPoints += this.fingerAccessory.getVitalityPoints();
            this.totalAttackPoints += this.fingerAccessory.getAttackPoints();
            this.totalMagicPoints += this.fingerAccessory.getMagicPoints();
            this.totalDefencePoints +=  this.fingerAccessory.getDefencePoints();
            this.totalMagicDefencePoints += this.fingerAccessory.getMagicDefencePoints();
            this.totalSpeedPoints += this.fingerAccessory.getSpeedPoints();
        }
      return true;
    }
    public ArmorLegs getLegArmor() {
        return this.legArmor;
    }

    public void setLegArmor(ArmorLegs legArmor) {
        if(this.legArmor != null) {

            totalDefencePoints -= this.legArmor.getDefencePoints();
            totalMagicDefencePoints -= this.legArmor.getMagicDefencePoints();
            totalSpeedPoints -= this.legArmor.getSpeedPoints();

            this.legArmor = legArmor;

            if(this.legArmor != null) {
                totalDefencePoints += this.legArmor.getDefencePoints();
                totalMagicDefencePoints += this.legArmor.getMagicDefencePoints();
                totalSpeedPoints += this.legArmor.getSpeedPoints();
            }

        }else{

            this.legArmor = legArmor;

            totalDefencePoints += this.legArmor.getDefencePoints();
            totalMagicDefencePoints += this.legArmor.getMagicDefencePoints();
            totalSpeedPoints += this.legArmor.getSpeedPoints();

        }
    }

    public ArmorFeet getFeetArmor() {
        return this.feetArmor;
    }

    public void setFeetArmor(ArmorFeet feetArmor) {
        if(this.feetArmor != null) {

            totalDefencePoints -= this.feetArmor.getDefencePoints();
            totalMagicDefencePoints -= this.feetArmor.getMagicDefencePoints();
            totalSpeedPoints -= this.feetArmor.getSpeedPoints();

            this.feetArmor = feetArmor;

            if(this.feetArmor != null) {
                totalDefencePoints += this.feetArmor.getDefencePoints();
                totalMagicDefencePoints += this.feetArmor.getMagicDefencePoints();
                totalSpeedPoints += this.feetArmor.getSpeedPoints();
            }

        }else{

            this.feetArmor = feetArmor;

            totalDefencePoints += this.feetArmor.getDefencePoints();
            totalMagicDefencePoints += this.feetArmor.getMagicDefencePoints();
            totalSpeedPoints += this.feetArmor.getSpeedPoints();

        }
    }




}
