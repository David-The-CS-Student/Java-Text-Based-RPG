package questPack;



public abstract class Quest {


    private String name;

    private String origin;
    private String difficultyStatus;
    private boolean active;
    private boolean complete;
    private String[] objectives;




    public Quest (final String name, final String origin, final String[] objectives, String difficultyStatus){

        this.name = name;
        this.objectives = objectives;
        this.difficultyStatus = difficultyStatus;
        this.origin = origin;
    }

    public final String getName() {
        return name;
    }

    public final String getOrigin(){return origin;}

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getReward(){
        return 250;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public abstract void setObjectiveValues(Object[] values);

    public abstract int getObjectiveCount();
    public String getObjective(int index){

        return this.objectives[index];
    }
    public void displayQuestInfo(){


        System.out.println("Quest Name: " + this.name);
        System.out.println("-----------------------------------------");

        System.out.println("<Objectives>");
        System.out.println("Go to the Destiny Town Sewers");
        for(int objectiveIndex = 0; objectiveIndex < objectives.length; objectiveIndex++)
        {
            System.out.println("-" + objectives[objectiveIndex]);
        }

        System.out.println("-----------------------------------------");
    }

    public String getDifficultyStatus() {
        return this.difficultyStatus;
    }

    @Override
    public boolean equals(Object obj) {

        if(obj instanceof Quest quest)
        {
            return this.name.equals(quest.name);
        }
        else{
            return super.equals(obj);
        }
    }

    public boolean isDigit(String string){

        boolean isDigitChar = false;
        for(int charIndex = 0; charIndex < string.length(); charIndex++)
        {
            if(Character.isDigit(string.charAt(charIndex)))
            {
                isDigitChar = true;

            }else{
                return false;
            }
        }

        return isDigitChar;
    }

    public abstract String getQuestData();


    public static void main(String[] args){

       //String[] testObjectives = {"Do this", "Do that", "And this"};
        //Quest testQuest1 = new QuestA("Test Quest", testObjectives );
        //Quest testQuest2 = new QuestA("Test Quest", testObjectives );
        //System.out.println(testQuest1.equals(testQuest2));
    }
}
