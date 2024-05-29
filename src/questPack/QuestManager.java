package questPack;

import java.util.ArrayList;

public class QuestManager {

    private static Quest currentQuest = null;

    private static ArrayList<Quest> completedQuests = new ArrayList<>(3);

    public static Quest getQuest(){

        return currentQuest;
    }
    public static void setQuest(Quest quest){

        currentQuest = quest;
    }

    public static void addCompletedQuest(Quest quest)
    {
        completedQuests.add(quest);
    }

    public static Object[] getCompletedQuests() {
        return completedQuests.toArray();
    }

    public static boolean questInProgress(){

        return currentQuest != null;
    }


}
