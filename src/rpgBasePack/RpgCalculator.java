
package rpgBasePack;
import rpgPlayerPack.PlayerWarrior;
import rpgEnemyPack.EnemyCharacter;


public class RpgCalculator {

    public static double physicalDamageCalculator(PlayerWarrior attacker, EnemyCharacter defender)
    {

        //to do: add a fraction of the level to the attacker and defender so higher levels get an advantage
        double damage = (attacker.getTotalAttackPoints() / defender.totalDefencePoints);

        if (damage < 1.0)
        {
            damage = 1.0;
            return damage;
        }

        return (Math.round(damage*100.0)/ 100.0);
    }

    public static double magicDamageCalculator(PlayerWarrior attacker, EnemyCharacter defender)
    {
        //to do: add a fraction of the level to the attacker and defender so higher levels get an advantage
        double damage = (attacker.getTotalMagicPoints() / defender.totalMagicDefencePoints);

        if (damage < 1.0)
        {
            damage = 1.0;
            return damage;
        }

        return (Math.round(damage*100.0)/ 100.0);
    }
    public static double physicalDamageCalculator(EnemyCharacter attacker , PlayerWarrior defender)
    {

        //to do: add a fraction of the level to the attacker and defender so higher levels get an advantage
        double damage = (attacker.totalAttackPoints/defender.getTotalDefencePoints());

        if (damage < 1.0)
        {
            damage = 1.0;
            return damage;
        }

        return (Math.round(damage*100.0)/ 100.0);
    }

    public static double magicDamageCalculator(EnemyCharacter attacker , PlayerWarrior defender)
    {
        //to do: add a fraction of the level to the attacker and defender so higher levels get an advantage
        double damage = (attacker.totalMagicPoints/defender.getTotalMagicDefencePoints());

        if (damage < 1.0)
        {
            damage = 1.0;
            return damage;
        }

        return (Math.round(damage*100.0)/ 100.0);
    }

    public static int levelCalculator(double exp)
    {

        return (int)((Math.log(exp/500.0)/Math.log(1.09)) + 1.0);
    }

    public static int expCalculator(int level)
    {

        return (int)(Math.ceil(500* Math.pow(1.09, level-1)));

    }

    public static void main(String[] args){


        System.out.print(47%2);


    }
}
