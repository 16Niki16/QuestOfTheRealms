package sofia.sap.interview.project.game.dto.savegame.data;

import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;

public class EnemyData {
    private EnemyType enemy;
    private int health;

    public EnemyType getEnemy() {
        return enemy;
    }

    public void setEnemy(EnemyType enemy) {
        this.enemy = enemy;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
