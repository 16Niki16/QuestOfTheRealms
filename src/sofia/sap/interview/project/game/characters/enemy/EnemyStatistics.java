package sofia.sap.interview.project.game.characters.enemy;

import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;

public class EnemyStatistics {
    private static final int MAX_STAT = 100;
    private static final int MIN_STAT = 0;
    private int health;

    public EnemyStatistics(EnemyType type) {
        this.health = type.getHealth();
    }

    public boolean decreaseHealth(int amount) {
        this.health -= amount;

        return this.health <= MIN_STAT;
    }

    public void increaseHealth(int amount) {
        this.health += amount;

        if (this.health > MAX_STAT) {
            this.health = MAX_STAT;
        }
    }
}
