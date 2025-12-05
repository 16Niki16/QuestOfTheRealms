package sofia.sap.interview.project.game.characters.enemy;

import sofia.sap.interview.project.game.characters.enemy.type.Type;
import sofia.sap.interview.project.game.exceptions.EnemyDeathException;

public class EnemyStatistics {
    private static final int MAX_STAT = 100;
    private static final int MIN_STAT = 0;
    private int health;

    public EnemyStatistics(Type type) {
        this.health = type.getHealth();
    }

    public int decreaseHealth(int amount) {
        this.health -= amount;

        if (this.health <= MIN_STAT) {
            throw new EnemyDeathException("The enemy is dead");
        }

        return this.health;
    }

    public int increaseHealth(int amount) {
        this.health += amount;

        if (this.health > MAX_STAT) {
            this.health = MAX_STAT;
        }

        return this.health;
    }
}
