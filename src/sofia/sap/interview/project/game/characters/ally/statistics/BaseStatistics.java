package sofia.sap.interview.project.game.characters.ally.statistics;

import sofia.sap.interview.project.game.characters.attack.AttackRange;

public abstract class BaseStatistics implements Statistics {
    protected static final int MAX_STAT = 100;
    protected static final int MIN_STAT = 0;
    private int health;
    private AttackRange attackRange;

    public BaseStatistics(int health, AttackRange attackRange) {
        this.attackRange = attackRange;
        this.health = health;
    }

    protected AttackRange getAttackRange() {
        return this.attackRange;
    }

    protected void setAttackRange(AttackRange attackRange) {
        this.attackRange = attackRange;
    }

    @Override
    public boolean decreaseHealth(int amount) {
        this.health -= amount;

        return this.health <= MIN_STAT;
    }

    @Override
    public void increaseHealth(int amount) {
        this.health += amount;

        if (this.health > MAX_STAT) {
            this.health = MAX_STAT;
        }
    }

    @Override
    public abstract int attack();
}
