package rpgItemPack;

import rpgEnemyPack.EnemyCharacter;
import rpgPlayerPack.PlayerWarrior;

public interface IUsable {


     void use(PlayerWarrior player);


    void use(EnemyCharacter enemy);

}
