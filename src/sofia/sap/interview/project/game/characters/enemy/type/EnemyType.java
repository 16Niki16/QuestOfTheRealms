package sofia.sap.interview.project.game.characters.enemy.type;

import sofia.sap.interview.project.game.characters.attack.AttackRange;

public enum EnemyType {
    BANDIT(20, new AttackRange(5, 10)),

    BOSS(40, new AttackRange(10, 15)),

    GOBLIN(20, new AttackRange(3, 8));

    private final int health;
    private final AttackRange attackRange;

    EnemyType(int health, AttackRange attackRange) {
        this.attackRange = attackRange;
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    public AttackRange getAttackRange() {
        return this.attackRange;
    }
}
