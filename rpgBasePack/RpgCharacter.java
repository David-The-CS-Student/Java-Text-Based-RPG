
package rpgBasePack;

public class RpgCharacter extends GameCharacter {

    private int level = 1;

    private int experience = 500;
    private Inventory inventory = null;


    public RpgCharacter(){super();}
    public RpgCharacter(String name, double baseHealth){
        super(name, baseHealth);
    }

    public RpgCharacter(String name, double baseHealth, Inventory inventory){
        super(name, baseHealth);
        this.inventory = inventory;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return this.experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public void displayClassInfo(){
        super.displayClassInfo();

        System.out.println("I am a RPG character");
    }

    @Override
    public String toString(){

        return "this - " + this.getClass().getSimpleName() + "\n" +
                " Character Name: " + this.getName() + " | " + "Lv: " + this.level + " | " +"Health Points: "+ this.getHealth();
    }


}
