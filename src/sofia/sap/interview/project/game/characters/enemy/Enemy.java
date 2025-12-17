package sofia.sap.interview.project.game.characters.enemy;

import sofia.sap.interview.project.game.characters.attack.AttackRange;
import sofia.sap.interview.project.game.characters.attack.AttackResult;
import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Enemy {
    private EnemyType type;
    private final EnemyStatistics enemyStats;

    public Enemy(EnemyType type) {
        this.enemyStats = new EnemyStatistics(type);
        this.type = type;
    }

    public AttackResult attackAllyCharacter() {
        int damage = attackDamage();
        return new AttackResult(damage, this.getDamageMessage(damage));
    }

    public int attackDamage() {
        AttackRange attackRange = type.getAttackRange();
        return ThreadLocalRandom.current().nextInt(attackRange.minDamage(), attackRange.maxDamage() + 1);
    }

    public void defendAgainstAllyCharacter(int damage) {
        this.enemyStats.decreaseHealth(damage);
    }

    public abstract String getDamageMessage(int damage);
}
