package sofia.sap.interview.project.game.map.dto.mappers;

import sofia.sap.interview.project.game.characters.enemy.Enemy;

public class EnemyMapper {
    public static Enemy map(String enemy) {
        if (enemy == null) {
            return null;
        }

        return Enemy.createEnemy(enemy);
    }
}
