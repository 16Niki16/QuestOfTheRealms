package sofia.sap.interview.project.game.characters.enemy;

import sofia.sap.interview.project.game.characters.attack.AttackRange;
import sofia.sap.interview.project.game.characters.attack.AttackResult;
import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Enemy {
    private final EnemyType type;
    private final EnemyStatistics enemyStats;

    public Enemy(EnemyType type) {
        this.enemyStats = new EnemyStatistics(type);
        this.type = type;
    }

    public static Enemy createEnemy(String type) {
        EnemyType enemy = EnemyType.getByName(type);

        return switch (enemy) {
            case GOBLIN -> new Goblin(enemy);
            case BOSS -> new Boss(enemy);
            case BANDIT -> new Bandit(enemy);
            case GOBLIN_KING -> new GoblinKing(enemy);
        };
    }

    public EnemyType getType() {
        return this.type;
    }

    public AttackResult attackAllyCharacter() {
        int damage = attackDamage();
        return new AttackResult(damage, this.getDamageMessage(damage));
    }

    public int attackDamage() {
        AttackRange attackRange = type.getAttackRange();
        return ThreadLocalRandom.current().nextInt(attackRange.minDamage(), attackRange.maxDamage() + 1);
    }

    public boolean defendAgainstAllyCharacter(int damage) {
        return this.enemyStats.decreaseHealth(damage);
    }

    public abstract String getDamageMessage(int damage);
}
