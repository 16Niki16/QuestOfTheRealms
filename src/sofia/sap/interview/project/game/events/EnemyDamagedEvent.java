package sofia.sap.interview.project.game.events;

import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;

public record EnemyDamagedEvent(EnemyType type, int damage) implements GameEvent {
    public static EnemyDamagedEvent damageEnemy(Enemy enemy, int damage) {
        return new EnemyDamagedEvent(enemy.getType(), damage);
    }
}
