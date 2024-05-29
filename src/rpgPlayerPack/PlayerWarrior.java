
package rpgPlayerPack;

import java.util.InputMismatchException;
import java.util.Scanner;

import mainApp.RpgGame;
import questPack.QuestManager;
import rpgBasePack.*;
import rpgItemPack.*;
import rpgEnemyPack.EnemyCharacter;
import saveFolder.Save;


enum WarriorType{

    Swordsman,
    Axeman,
    Mage,
    Bowman

};
public class PlayerWarrior extends RpgCharacter {

    private BaseAttributes attributes = null;

    private int attributesPoints = 0;
    private WarriorType warriorType;
    private PlayerEquipment equipment = null;
    private WeaponPrimary primaryWeapon = null;
    private WeaponSecondary secondaryWeapon = null;
    private ArmorHead headArmor = null;
    private AccessoryNeck neckAccessory = null;
    private ArmorTorso torsoArmor = null;

    private AccessoryFinger fingerAccessory =null;
    private ArmorLegs legArmor = null;
    private ArmorFeet feetArmor = null;
    private Mount mount = null;
    private Item gold = null;

    public String locationName;
    private double totalVitalityPoints = 0;
    private double totalAttackPoints = 0;
    private double totalMagicPoints = 0;

    private double totalDefencePoints = 0;

    private double totalMagicDefencePoints = 0;

    private double totalSpeedPoints = 0;

    public PlayerWarrior(){super();}

    public PlayerWarrior(String name, BaseAttributes attributes){

        super(name, 10.0, new PlayerInventory());

        this.getPlayerInventory().setCurrentPlayer(this);
        this.attributes = attributes;

        this.equipment = new PlayerEquipment();

        this.getEquipment().setCurrentPlayer(this);

        this.totalAttackPoints += this.attributes.getAttack();

        this.totalMagicPoints += this.attributes.getMagic();

        this.totalDefencePoints += this.attributes.getDefence();

        this.totalMagicDefencePoints += this.attributes.getMagicDefence();

        this.totalSpeedPoints += this.attributes.getSpeed();
    }

    public PlayerWarrior(PlayerWarrior copy)
    {

        this.setName(copy.getName());
        this.warriorType = copy.warriorType;
        this.attributesPoints = copy.attributesPoints;

        this.setLevel(copy.getLevel());
        this.setExperience(copy.getExperience());


        this.setAttributes(copy.getAttributes());
        this.totalVitalityPoints += copy.getAttributes().getVitality();
        this.totalAttackPoints += copy.getAttributes().getAttack();
        this.totalMagicPoints += copy.getAttributes().getMagic();
        this.totalDefencePoints += copy.getAttributes().getDefence();
        this.totalMagicDefencePoints += copy.getAttributes().getMagicDefence();
        this.totalSpeedPoints += copy.getAttributes().getSpeed();

        this.gold = copy.gold;
        this.setInventory( new PlayerInventory(copy.getPlayerInventory()));

        this.getPlayerInventory().setCurrentPlayer(this);
        for(int itemIndex = 0; itemIndex < this.getInventory().getCount(); itemIndex++)
        {
            Item item = this.getInventory().getItem(itemIndex);
            item.setPlayerOwner(this);
        }

        this.setEquipment( new PlayerEquipment(copy.getEquipment()));

        this.getEquipment().setCurrentPlayer(this);
        for(int itemIndex = 0; itemIndex < getEquipment().getCount(); itemIndex++)
        {
            Item item = this.getEquipment().getItem(itemIndex);
            if(item instanceof IEquipable equipable)
            {
                item.setPlayerOwner(this);
                equipable.equip();
            }
        }



        this.setHealth(copy.getHealth());

        this.locationName = copy.locationName;
    }


    public BaseAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(BaseAttributes attributes) {
        this.attributes = attributes;
    }

    public void initializeTotalAttributes(){

        this.totalAttackPoints = this.attributes.getAttack();

        this.totalMagicPoints = this.attributes.getMagic();

        this.totalDefencePoints = this.attributes.getDefence();

        this.totalMagicDefencePoints = this.attributes.getMagicDefence();

        this.totalSpeedPoints = this.attributes.getSpeed();

    }
    public PlayerEquipment getEquipment(){return this.equipment;}
    public void setEquipment(PlayerEquipment newEquipment){ this.equipment = newEquipment; }
    public PlayerInventory getPlayerInventory()
    {
        return (PlayerInventory) this.getInventory();
    }


    @Override
    public double getMaxHealth() {
        return (this.getBaseHealth() + this.totalVitalityPoints);
    }

    public int getAttributesPoints() {
        return this.attributesPoints;
    }

    public void addAttributesPoints(int points){

        this.attributesPoints += points;

    }

    public void subtractAttributePoints(int points)
    {
        this.attributesPoints -= points;
    }

    public double getTotalVitalityPoints(){

        return this.totalVitalityPoints;

    }

    public void addTotalVitalityPoints(double points)
    {
        this.totalVitalityPoints += points;
    }
    public double getTotalAttackPoints()
    {

         return this.totalAttackPoints;
    }

    public double getTotalMagicPoints() {


        return this.totalMagicPoints;
    }

    public double getTotalDefencePoints() {

        return this.totalDefencePoints;
    }

    public double getTotalMagicDefencePoints() {

        return this.totalMagicDefencePoints;
    }


    public double getTotalSpeedPoints() {

       return this.totalSpeedPoints;

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
            this.totalMagicPoints -= this.primaryWeapon.getMagicPoints();

            this.primaryWeapon = primaryWeapon;

            if(this.primaryWeapon != null) {

               this.totalAttackPoints += primaryWeapon.getAttackPoints();
               this.totalDefencePoints += primaryWeapon.getDefencePoints();
               this.totalSpeedPoints += primaryWeapon.getSpeedPoints();
                this.totalMagicPoints += primaryWeapon.getMagicPoints();
            }

        }else{


            this.primaryWeapon = primaryWeapon;

            if(this.primaryWeapon != null) {

                this.totalAttackPoints += this.primaryWeapon.getAttackPoints();
                this.totalDefencePoints += this.primaryWeapon.getDefencePoints();
                this.totalSpeedPoints += this.primaryWeapon.getSpeedPoints();
                this.totalMagicPoints += this.primaryWeapon.getMagicPoints();
            }



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
                this.totalMagicPoints -= this.secondaryWeapon.getMagicPoints();

            this.secondaryWeapon = secondaryWeapon;

            if(this.secondaryWeapon != null) {

                this.totalAttackPoints += secondaryWeapon.getAttackPoints();
                this.totalDefencePoints += secondaryWeapon.getDefencePoints();
                this.totalSpeedPoints += secondaryWeapon.getSpeedPoints();
                this.totalMagicPoints += this.secondaryWeapon.getMagicPoints();
            }

        }else{

            this.secondaryWeapon = secondaryWeapon;

            if(this.secondaryWeapon != null) {

                this.totalAttackPoints += this.secondaryWeapon.getAttackPoints();
                this.totalDefencePoints += this.secondaryWeapon.getDefencePoints();
                this.totalSpeedPoints += this.secondaryWeapon.getSpeedPoints();
                this.totalMagicPoints += this.secondaryWeapon.getMagicPoints();
            }
        }

        return true;
    }

    public ArmorHead getArmor() {
        return this.headArmor;
    }

    public boolean setHeadArmor(ArmorHead head) {
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

            if(this.headArmor != null) {

                totalDefencePoints += this.headArmor.getDefencePoints();
                totalMagicDefencePoints += this.headArmor.getMagicDefencePoints();
                totalSpeedPoints += this.headArmor.getSpeedPoints();
            }
        }

        return true;
    }

    public AccessoryNeck getNeckAccessory(){return this.neckAccessory;}

    public boolean setNeckAccessory(AccessoryNeck neckAccessory)
    {

        if(this.neckAccessory != null)
        {

            this.totalVitalityPoints -= this.neckAccessory.getVitalityPoints();

            this.totalAttackPoints -= this.neckAccessory.getAttackPoints();
            this.totalMagicPoints -= this.neckAccessory.getMagicPoints();
            this.totalDefencePoints -= this.neckAccessory.getDefencePoints();
            this.totalMagicDefencePoints -= this.neckAccessory.getMagicDefencePoints();
            this.totalSpeedPoints -= this.neckAccessory.getSpeedPoints();
         }

        this.neckAccessory = neckAccessory;

        if(this.neckAccessory != null)
        {
            this.totalVitalityPoints += this.neckAccessory.getVitalityPoints();

            this.totalAttackPoints += this.neckAccessory.getAttackPoints();
            this.totalMagicPoints += this.neckAccessory.getMagicPoints();
            this.totalDefencePoints +=  this.neckAccessory.getDefencePoints();
            this.totalMagicDefencePoints += this.neckAccessory.getMagicDefencePoints();
            this.totalSpeedPoints += this.neckAccessory.getSpeedPoints();
        }

        return true;
    }

    public ArmorTorso getTorsoArmor() {
        return this.torsoArmor;
    }

    public boolean setTorsoArmor(ArmorTorso torsoArmor) {

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

            if(this.torsoArmor != null) {

                totalDefencePoints += this.torsoArmor.getDefencePoints();
                totalMagicDefencePoints += this.torsoArmor.getMagicDefencePoints();
                totalSpeedPoints += this.torsoArmor.getSpeedPoints();

            }
        }

        return true;
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

    public boolean setLegArmor(ArmorLegs legArmor) {
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

            if(this.legArmor != null) {
                totalDefencePoints += this.legArmor.getDefencePoints();
                totalMagicDefencePoints += this.legArmor.getMagicDefencePoints();
                totalSpeedPoints += this.legArmor.getSpeedPoints();
            }
        }

        return true;
    }

    public ArmorFeet getFeetArmor() {
        return this.feetArmor;
    }

    public boolean setFeetArmor(ArmorFeet feetArmor) {
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

            if(this.feetArmor != null) {
                totalDefencePoints += this.feetArmor.getDefencePoints();
                totalMagicDefencePoints += this.feetArmor.getMagicDefencePoints();
                totalSpeedPoints += this.feetArmor.getSpeedPoints();
            }
        }

        return true;
    }

    public Mount getMount() {
        return mount;
    }

    public void setMount(Mount mount) {
        this.mount = mount;
    }

    public Item getGold(){

        return gold;
    }

    public void setGold(Item gold){
        this.gold = gold;
    }

    public WarriorType getWarriorType(){

        return this.warriorType;
    }

    public int getExpToNextLv()
    {

        return RpgCalculator.expCalculator(getLevel() + 1 );
    }


    public void attack(EnemyCharacter enemyCharacter)
    {

        double playerDamage = RpgCalculator.physicalDamageCalculator(this, enemyCharacter);

        double enemyHealth = enemyCharacter.getHealth() - playerDamage;

        enemyCharacter.setHealth(enemyHealth);

        System.out.println(this.getName() + " deals " + playerDamage + " damage");

        if(enemyCharacter.getHealth() < 0)
        {
            enemyCharacter.setHealth(0);
        }
    }

    @Override
    public void displayClassInfo()
    {
        super.displayClassInfo();

        System.out.println("I am a warrior");
    }


    public String displayAttributes(){

        String result = "";
        String baseAttributesHeader = "|------Base Attributes-----";
        String totalAttributesHeader = "------Total Attributes-----|";



        String dashes = "-".repeat((baseAttributesHeader.length()+totalAttributesHeader.length()) +1) + "\n";
        String header =  baseAttributesHeader + "|" + totalAttributesHeader + "\n";

        result += dashes + header;

        String baseVitalityRow = "|Vitality: " + String.format("%.0f", this.attributes.getVitality()) + String.format("%16s", "|" );
        String totalVitalityRow = "Vitality: " + String.format("%.0f", this.totalVitalityPoints) + String.format("%17s", "|" )+"\n";

        result += baseVitalityRow + totalVitalityRow;

        String baseAttackRow = "|Attack: " + String.format("%.0f", this.attributes.getAttack()) + String.format("%18s", "|" );
        String totalAttackRow = "Attack: " + String.format("%.0f", this.totalAttackPoints) +String.format("%19s", "|" ) + "\n";

        result += baseAttackRow + totalAttackRow;

        String baseMagicRow = "|Magic: " + String.format("%.0f", this.attributes.getMagic()) + String.format("%19s", "|" );
        String totalMagicRow = "Magic: " + String.format("%.0f", this.totalMagicPoints) +  String.format("%20s", "|" )+"\n";

        result += baseMagicRow + totalMagicRow;

        String baseDefenceRow = "|Defence: " + String.format("%.0f", this.attributes.getDefence()) + String.format("%17s", "|" );
        String totalDefenceRow = "Defence: " + String.format("%.0f", this.totalDefencePoints) +String.format("%17s", "|" )+"\n";

        result += baseDefenceRow + totalDefenceRow;

        String baseMagicDefenceRow = "|Magic Defence: " + String.format("%.0f", this.attributes.getMagicDefence()) + String.format("%11s", "|" );
        String totalMagicDefenceRow = "Magic Defence: " + String.format("%.0f", this.totalMagicDefencePoints) +String.format("%12s", "|" ) +"\n";


        result += baseMagicDefenceRow + totalMagicDefenceRow;

        String baseSpeedRow = "|Speed: " + String.format("%.0f", this.attributes.getSpeed()) + String.format("%19s", "|" );
        String totalSpeedRow = "Speed: " + String.format("%.0f", this.totalSpeedPoints) +String.format("%19s", "|" ) +"\n";

        result += baseSpeedRow + totalSpeedRow;

        result += dashes;

        return result;
    }


    public void displayPlayerProfile(){

        Scanner input = new Scanner(System.in);

        while(true) {

            System.out.print(this);
           
            System.out.println("1 View Inventory");
            System.out.println("2 View Equipment");
            System.out.println("3 View Quest");
            System.out.println("4 Distribute Attribute Points");
            System.out.println("5 Exit");

            int choice =0;
            try {
               choice= input.nextInt();
            }catch(InputMismatchException exc){

                input.nextLine();
                continue;
            }
            if(choice == 1)
            {
                this.getPlayerInventory().use();
            }
            else if(choice == 2)
            {
                this.getEquipment().use();
            }
            else if(choice == 3){
                if(QuestManager.questInProgress())
                {
                    while(true) {
                        QuestManager.getQuest().displayQuestInfo();

                        System.out.println("1 Exit");
                        choice = input.nextInt();

                        if(choice == 1)
                        {
                            break;
                        }
                    }
                }else{
                    System.out.println("There is no active quest");
                }
            }else if(choice == 4){
                if(this.attributesPoints > 0) {

                    mainLoop:
                    while (true) {

                        System.out.println("Attribute Points: " + this.attributesPoints + " Select an attribute");
                        System.out.println("1 Vitality");
                        System.out.println("2 Attack");
                        System.out.println("3 Magic");
                        System.out.println("4 Defence");
                        System.out.println("5 Magic Defence");
                        System.out.println("6 Speed");
                        System.out.println("7 Exit");

                        int attrChoice = 0;
                        try {

                            attrChoice = RpgGame.getInput().nextInt();

                        } catch (InputMismatchException exc) {
                            RpgGame.getInput().nextLine();
                            continue;
                        }


                        int amount = 0;
                        while (attrChoice > 0 && attrChoice < 7) {

                            System.out.print("How many points do you want to distribute? ");

                            try {

                                amount = RpgGame.getInput().nextInt();

                            } catch (InputMismatchException exc) {

                                RpgGame.getInput().nextLine();

                                continue;
                            }

                            if (amount > this.attributesPoints) {
                                System.out.println("To high");
                                continue;
                            } else if (amount < 0) {
                                System.out.println("To low");
                                continue;
                            }

                            break;

                        }

                        switch (attrChoice) {
                            case 1:

                                double newVitality = this.attributes.getVitality() + amount;
                                this.attributes.setVitality(newVitality);

                                this.totalVitalityPoints += amount;


                                break;

                            case 2:

                                double newAttack = this.attributes.getAttack() + amount;
                                this.attributes.setAttack(newAttack);

                                this.totalAttackPoints += amount;

                                break;
                            case 3:

                                double newMagic = this.attributes.getMagic() + amount;
                                this.attributes.setMagic(newMagic);

                                this.totalMagicPoints += amount;

                                break;
                            case 4:

                                double newDefence = this.attributes.getDefence() + amount;
                                this.attributes.setDefence(newDefence);

                                this.totalDefencePoints += amount;

                                break;

                            case 5:

                                double newMagicDefence = this.attributes.getMagicDefence() + amount;
                                this.attributes.setMagicDefence(newMagicDefence);

                                this.totalMagicDefencePoints += amount;
                                break;

                            case 6:

                                double newSpeed = this.attributes.getSpeed() + amount;
                                this.attributes.setSpeed(newSpeed);

                                this.totalSpeedPoints += amount;
                                break;

                            case 7:
                                break mainLoop;

                            default:
                                continue;
                        }

                        this.subtractAttributePoints(amount);

                    }
                }else{
                    System.out.println("You have no attribute points.");
                }

            }  else if(choice == 5) {

                System.out.println();
                break;
            }

        }
    }

    @Override
    public String toString()
    {

        if(attributes == null) {

            return super.toString() + " | " + "Gold: " + this.gold.getCount();

        }else{
            return super.toString() + " | " + "Gold: " + this.gold.getCount() + "\n" +

                   this.displayAttributes();
        }
    }

    public PlayerWarrior clone(){
        return new PlayerWarrior(this);
    }
}
