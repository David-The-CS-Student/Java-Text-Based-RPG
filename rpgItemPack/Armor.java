
package rpgItemPack;
import rpgPlayerPack.PlayerWarrior;
import rpgEnemyPack.EnemyWarrior;
import rpgBasePack.BaseAttributes;



public abstract class Armor extends Item implements IEquipable {


    private BaseAttributes attributes;



    //make constructor


    private EquipType equipType;
    public Armor(){}
    public Armor(String name){

        super(name);

    }

    public Armor(String name, String description, IEquipable.EquipType type, int price, PlayerWarrior owner){

        super(name, description, price);
        setPlayerOwner(owner);
        this.equipType = type;
    }

    public Armor(String name, String description, IEquipable.EquipType type, int price, PlayerWarrior owner, BaseAttributes attributes){

        super(name, description, price);
        this.equipType = type;
        setPlayerOwner(owner);
        this.attributes = attributes;
    }

    public Armor(String name, String description, IEquipable.EquipType type, int price, BaseAttributes attributes){

        super(name, description, price);
        this.equipType = type;
        this.attributes = attributes;
    }

    public Armor(String name, String description, IEquipable.EquipType type, int price, EnemyWarrior owner){

        super(name, description, price);
        setEnemyOwner(owner);
        this.equipType = type;
    }

    public Armor(String name, String description, IEquipable.EquipType type, int price, EnemyWarrior owner, BaseAttributes attributes){

        super(name, description,price);
        setEnemyOwner(owner);
        this.attributes = attributes;
        this.equipType = type;
    }

    public Armor(Armor copy){

        super(copy);
        this.setAttributes(copy.attributes);
        this.equipType = copy.equipType;
    }

    public BaseAttributes getAttributes()
    {

        return this.attributes;
    }

    public double getDefencePoints() {
        return this.attributes.getDefence();
    }

    public double getMagicDefencePoints() {
        return this.attributes.getMagicDefence();
    }

    public double getSpeedPoints() {
        return this.attributes.getSpeed();
    }

    public void setAttributes(BaseAttributes attributes) {
        this.attributes = attributes;
    }


    @Override
    public EquipType getEquipType(){
        return this.equipType;
    }

    @Override
    public void setEquipType(EquipType equipType) {
        this.equipType = equipType;
    }





    public abstract boolean equip();

    public abstract void unEquip();

    //method for wearing armor?



    @Override
    public String toString() {
        return "Item Name: "+ getName() +" | " + "Description: "+ getDescription();
    }




}