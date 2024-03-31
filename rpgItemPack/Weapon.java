

package rpgItemPack;
import rpgBasePack.BaseAttributes;
import rpgPlayerPack.PlayerWarrior;
import rpgEnemyPack.EnemyWarrior;


public abstract class Weapon extends Item implements IEquipable {

    private BaseAttributes attributes;

    private  IEquipable.EquipType equipType;

    public Weapon(){}
    public Weapon(String name){

        super(name);

    }

    public Weapon(String name, String description, IEquipable.EquipType type, int price, PlayerWarrior owner){

        super(name, description, price);
        setPlayerOwner(owner);
        this.equipType = type;
    }
    public Weapon(String name, String description, IEquipable.EquipType type, int price, BaseAttributes attributes){

        super(name, description,price);
        this.attributes = attributes;
        this.equipType = type;
    }
    public Weapon(String name, String description, IEquipable.EquipType type, int price, PlayerWarrior owner, BaseAttributes attributes){

        super(name, description,price);
        setPlayerOwner(owner);
        this.attributes = attributes;
        this.equipType = type;
    }

    public Weapon(String name, String description, IEquipable.EquipType type, int price, EnemyWarrior owner){

        super(name, description, price);
        setEnemyOwner(owner);
        this.equipType = type;
    }

    public Weapon(String name, String description, IEquipable.EquipType type, int price, EnemyWarrior owner, BaseAttributes attributes){

        super(name, description,price);
        setEnemyOwner(owner);
        this.attributes = attributes;
        this.equipType = type;
    }

    Weapon(Weapon copy){

        super(copy);
        this.attributes = copy.attributes;
        this.equipType = copy.equipType;
    }

    public BaseAttributes getAttributes(){

        return this.attributes;
    }

    public double getAttackPoints()
    {
        return this.attributes.getAttack();
    }

    public double getMagicPoints() {
        return this.attributes.getMagic();
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
    public IEquipable.EquipType getEquipType() {
        return this.equipType;
    }

    @Override
    public void setEquipType(IEquipable.EquipType equipType) {
        this.equipType = equipType;
    }

    public abstract boolean equip();

    public abstract  void unEquip();


    @Override
    public String toString() {
        return "Item Name: "+ getName() +" | " + "Description: "+ getDescription();
    }


}
