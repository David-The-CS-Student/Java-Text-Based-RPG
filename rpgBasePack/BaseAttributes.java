
package rpgBasePack;

public class BaseAttributes {


    private double vitality;
    private double attack, magic;
    private double defence, magicDefence;
    private double speed;

   public BaseAttributes(){

       this.vitality = 0;
       this.attack = 0;
       this.magic =0;
       this.defence = 0;
       this.magicDefence = 0;
       this.speed = 0;

   }
    public BaseAttributes(double vitality, double attack, double magic, double defence, double magicDefence, double speed)
    {
        this.vitality = vitality;
        this.attack = attack;
        this.magic = magic;
        this.defence = defence;
        this.magicDefence = magicDefence;
        this.speed = speed;

    }

    public double getVitality() {
        return vitality;
    }

    public void setVitality(double vitality) {
        this.vitality = vitality;
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public double getMagic() {
        return magic;
    }

    public void setMagic(double magic) {
        this.magic = magic;
    }

    public double getDefence() {
        return defence;
    }

    public void setDefence(double defence) {
        this.defence = defence;
    }

    public double getMagicDefence() {
        return magicDefence;
    }

    public void setMagicDefence(double magicDefence) {
        this.magicDefence = magicDefence;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public String toString()
    {

        return "----- Base Attributes----- \n" +
                "Vitality: " + vitality + "\n" +
                "Attack: " + attack + "\n"+
                "Magic: " + magic + "\n" +
                "Defence: " + defence + "\n"+
                "Magic Defence: " + magicDefence + "\n" +
                "Speed: " + speed;
    }
}
