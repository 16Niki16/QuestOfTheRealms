package sofia.sap.interview.project.game.events;

import sofia.sap.interview.project.game.characters.enemy.Enemy;

public class KillEnemyEvent implements GameEvent {
    private final Enemy enemy;

    public KillEnemyEvent(Enemy enemy) {
        this.enemy = enemy;
    }

    public Enemy getKilledEnemy() {
        return this.enemy;
    }
}
