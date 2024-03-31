package questPack;

import rpgEnemyPack.EnemyCharacter;
import rpgEnemyPack.GiantRat;
import rpgItemPack.Item;

public class GiantRatQuest extends Quest {

    final int ratsToKill = 10;
    private int ratKillCount = 0;

    final int ratPeltsToCollect = 1;
    private int ratPeltCount = 0;

    public GiantRatQuest(){
        super("Big Rat Problems", "Destiny Town", new String[]{"Kill 10 giant rats", "Collect 1 rat pelts"}, "Easy" );
    }

    public int getRatKillCount() {
        return ratKillCount;
    }

    public void setRatKillCount(int ratKillCount) {
        this.ratKillCount = ratKillCount;
    }

    public void incrementRatKillCount(EnemyCharacter enemy) {
        if (killRatio() < 100.0) {
            if (enemy instanceof GiantRat && enemy.getHealth() <= 0) {
                this.ratKillCount++;
            }
        }
    }

    public double killRatio(){
        double ratio = ((double)ratKillCount/(double)ratsToKill);
        return Math.round((ratio) * 100.0);
    }

    public int getRatPeltCount() {
        return ratPeltCount;
    }

    public void setRatPeltCount(int ratPeltCount) {
        this.ratPeltCount = ratPeltCount;
    }

    public void incrementRatPeltCount(Item pelts) {
        if (peltCollectionRatio() < 100) {

            if (pelts.getName().equals("Giant Rat Pelt")) {

                this.ratPeltCount++;
            }
        }
    }


    public double peltCollectionRatio(){
        double ratio = (double)ratPeltCount/(double)ratPeltsToCollect;
        return Math.round(ratio * 100.0);
    }


    @Override
    public boolean isComplete() {
        return killRatio() == 100.0 && peltCollectionRatio() == 100.0;
    }


    @Override
    public void setObjectiveValues(Object[] values) {

        if(isDigit((String)values[0]))
        {
            ratKillCount = Integer.parseInt((String)values[0]);
        }

        if(isDigit((String)values[1]))
        {
            ratPeltCount = Integer.parseInt((String)values[1]);
        }

    }

    @Override
    public int getObjectiveCount() {
        return 2;
    }

    @Override
    public void displayQuestInfo(){

        super.displayQuestInfo();

        if(isActive()) {
            System.out.println("Rats killed: " + ratKillCount + " | " + "You are " + killRatio() + "% " + "done");

            System.out.println("Pelts Collected: " + ratPeltCount + " | " + "You are " + peltCollectionRatio() + "% " + "done");
        }
    }

    @Override
    public String getQuestData() {
        String questData = ratKillCount + " " + ratPeltCount;
        return  questData;
    }

    public static void main(String[] args){

    }
}
