package sofia.sap.interview.project.game.characters.enemy;

import sofia.sap.interview.project.game.characters.attack.AttackRange;
import sofia.sap.interview.project.game.characters.attack.AttackResult;
import sofia.sap.interview.project.game.characters.enemy.type.Type;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Enemy {
    private Type type;
    private final EnemyStatistics enemyStats;

    public Enemy(Type type) {
        this.enemyStats = new EnemyStatistics(type);
        this.type = type;
    }

    public AttackResult attack() {
        int damage = attackDamage();
        return new AttackResult(damage, this.getDamageMessage(damage));
    }

    public int attackDamage() {
        AttackRange attackRange = getAttackRange();
        return ThreadLocalRandom.current().nextInt(attackRange.minDamage(), attackRange.maxDamage() + 1);
    }

    public AttackRange getAttackRange() {
        return this.type.getAttackRange();
    }

    public abstract String getDamageMessage(int damage);
}
