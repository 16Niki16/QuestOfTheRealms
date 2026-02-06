package sofia.sap.interview.project.game.gameplay.command;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.enemy.Enemy;

public class AttackCommand implements Command {
    private final Character character;
    private final Enemy enemy;

    public AttackCommand(Character character, Enemy enemy) {
        this.character = character;
        this.enemy = enemy;
    }

    @Override
    public void execute() {
        int damage = character.attackEnemy();
        enemy.defendAgainstAllyCharacter(damage);
    }
}
