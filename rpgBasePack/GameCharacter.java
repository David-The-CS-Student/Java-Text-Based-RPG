
package rpgBasePack;
public class GameCharacter {

    private String name;
    private double maxHealth;
    private double health;

    private double baseHealth = 10;
    public GameCharacter() {
        this.name = "N/A";
        this.maxHealth = 0.0;
        this.health = 0.0;
    }

    public GameCharacter(String name, double baseHealth) {

        this.name = name;

        this.baseHealth = baseHealth;
        this.maxHealth = this.baseHealth;

        this.health = this.maxHealth;

    }

    public final String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public double getHealth() {
        return this.health;
    }
    public final void setHealth(double newHealth) {

        this.health = newHealth;

    }
    public final double getBaseHealth(){
        return this.baseHealth;
    }

    public double getMaxHealth(){
        return this.maxHealth;
    }

    public void setMaxHealth(double maxHealth) {
        this.maxHealth = maxHealth;
    }

    public double getHealthRatio(){

        return this.health/this.maxHealth;
    }

    public void displayClassInfo(){

        System.out.println("I am a game character");

    }

    public static String getTypeName(GameCharacter gc){

        return "This GameCharacter is of type "+ gc.getClass().getTypeName();
    }


    @Override
    public String toString()
    {
        return "this - " + this.getClass().getSimpleName() + "\n" +
                " Character Name: " + this.getName() + " | " + "Health Points: "+ this.getHealth();
    }
}
