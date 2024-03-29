package adminPack;

import mainApp.RpgGame;
import rpgBattlePack.Battle;
import rpgEnemyPack.EnemyCharacter;

import java.lang.reflect.InvocationTargetException;
import java.util.InputMismatchException;

public class AdminBattleState  extends RpgAdminState{

    public AdminBattleState(){super(AdminState.Battle);}


    @Override
    public void update() {

        while(true){

            System.out.println("Select the following options.");

            System.out.println("1. Battle NPC");
            System.out.println("2. Main Menu");
            System.out.print("Option: ");

            int option;

            try{

                option = RpgGame.getInput().nextInt();
                System.out.println();
            }catch (InputMismatchException exc)
            {
                RpgGame.getInput().nextLine();
                continue;
            }

            if(option == 1)
            {
                while (true) {

                    System.out.println("Please enter the class name of a enemy character or (e) to exit.");
                    System.out.print("Class Name: ");

                    String input = RpgGame.getInput().next();

                    if(input.equals("e"))
                    {
                        break;
                    }

                    try{

                        Class<?> enemyClass = Class.forName("rpgEnemyPack." + input);

                        EnemyCharacter enemyCharacterInstance = (EnemyCharacter) enemyClass.getDeclaredConstructor().newInstance();

                        Battle adminBattle = new Battle(RpgAdminStateMachine.getAdminPlayer(),enemyCharacterInstance);

                        adminBattle.update();

                    } catch (ClassNotFoundException e) {

                        System.out.println("Status: Class Not Found");
                        System.out.println();

                    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException |
                             InstantiationException e) {
                        throw new RuntimeException(e);
                    }


                }

            } else if (option == 2) {

                RpgAdminStateMachine.getInstance().setCurrentState(AdminState.MainMenu);
                break;
            }


        }
    }

    @Override
    public String toString() {
        return getState().name();
    }
}
