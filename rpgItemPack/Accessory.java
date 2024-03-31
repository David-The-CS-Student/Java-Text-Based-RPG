package rpgItemPack;

import rpgBasePack.BaseAttributes;
import rpgEnemyPack.EnemyWarrior;
import rpgPlayerPack.PlayerWarrior;

public abstract class Accessory extends Item implements IEquipable {


    private BaseAttributes attributes;
    private EquipType equipType;



    public Accessory(){

        super();

    }

    public Accessory(String name, String description, EquipType type, int price, BaseAttributes attr)
    {

        super(name, description, price);

        this.equipType = type;

        this.attributes = attr;

    }

    public Accessory(String name, String description, EquipType type, int price, BaseAttributes attr, PlayerWarrior owner)
    {

       super(name, description, price);
       setPlayerOwner(owner);
       this.equipType = type;
       this.attributes = attr;

    }

    public Accessory(String name, String description, EquipType type, int price, BaseAttributes attr, EnemyWarrior owner)
    {
        super(name, description, price);
        setEnemyOwner(owner);
        this.equipType = type;
        this.attributes = attr;
    }

    public Accessory(Accessory copy){

        super(copy);
        this.setAttributes(copy.attributes);
        this.equipType = copy.equipType;
    }

    public BaseAttributes getAttributes() {
        return this.attributes;
    }


    public double getVitalityPoints(){return this.attributes.getVitality();}

    public double getAttackPoints(){return this.attributes.getAttack();}

    public double getMagicPoints(){return this.attributes.getMagic();}
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

    public abstract  void unEquip();
}
