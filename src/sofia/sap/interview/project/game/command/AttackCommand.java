package sofia.sap.interview.project.game.command;

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
    public CommandResult execute() {
        int damage = character.attackEnemy();
        enemy.defendAgainstAllyCharacter(damage);
        return new CommandResult(character.damageMessage(damage));
    }
}
