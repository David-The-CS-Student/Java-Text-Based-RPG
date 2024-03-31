package rpgItemPack;
import rpgBasePack.RpgCharacter;

public class Mount {

    private String name;

    private RpgCharacter owner = null;

    private char grade;
    private int speed;


    public Mount(){}

    //grade of mounts is from A to D
    public Mount(String name, char grade){
        this.name = name;
        setGrade(grade);

    }
    //grade of mounts is from A to D
    public Mount (String name, char grade, RpgCharacter owner)
    {
        this.name = name;

        this.owner = owner;

        setGrade(grade);
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public RpgCharacter getOwner() {
        return owner;
    }

    public void setOwner(RpgCharacter owner) {
        this.owner = owner;
    }

    public int getSpeed() {
        return speed ;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public char getGrade()
    {
        return this.grade;
    }

    public void setGrade(char grade) {

        this.grade = grade;

        setSpeedByGrade();
    }

    //grade of mounts is from A to D
    private void setSpeedByGrade(){

        switch(grade)
        {
            case 'A': this.speed = 31; break;
            case 'B': this.speed = 25; break;

            case 'C': this.speed = 20; break;
            case 'D': this.speed = 15; break;
        }

    }

    public void ride(){

        if(owner != null)
        {
            System.out.println(owner.getName() + " rides their mount at "+ speed + "m/s");

        }else{

            System.out.println("This mount need an owner to ride!");
        }
    }

    @Override
    public String toString()
    {
        if(owner == null) {
            return "this - " + this.getClass().getSimpleName() + "\n"+
                    " Mount Name: " + this.name + " | " + "Owner: none";
        }else{

            return "this - " + this.getClass().getSimpleName() + "\n"+
                    " Mount Name: " + this.name + " | " + "Owner: " +  owner.getName();
        }
    }

}
