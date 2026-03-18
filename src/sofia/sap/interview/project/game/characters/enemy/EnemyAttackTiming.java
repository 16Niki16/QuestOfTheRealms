package sofia.sap.interview.project.game.characters.enemy;

import sofia.sap.interview.project.game.command.result.CommandResult;

import java.util.List;

public class EnemyAttackTiming {
    private static final int COOLDOWN = 8000;
    private Enemy enemy;
    private long lastAttack;

    public EnemyAttackTiming(Enemy enemy) {
        this.enemy = enemy;
        this.lastAttack = System.currentTimeMillis();
    }

    public boolean canAttack() {
        return System.currentTimeMillis() - lastAttack >= COOLDOWN;
    }

    public List<CommandResult>
}
