package sofia.sap.interview.project.game.dto.savegame.factory;

import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.dto.savegame.data.EnemyData;

public class EnemyDataFactory {
    public static EnemyData create(Enemy enemy) {
        EnemyData enemyData = new EnemyData();
        enemyData.setEnemy(enemy.getType());
        enemyData.setHealth(enemy.health());
        return enemyData;
    }
}
