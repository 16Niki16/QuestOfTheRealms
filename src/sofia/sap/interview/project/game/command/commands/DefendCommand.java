package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.command.CommandResult;

public class DefendCommand implements Command {
    private final Character character;
    private final Enemy enemy;

    public DefendCommand(Character character, Enemy enemy) {
        this.character = character;
        this.enemy = enemy;
    }

    @Override
    public CommandResult execute() {
        int damage = enemy.attackDamage();
        this.character.defendAgainstEnemy(damage);

        return new CommandResult(enemy.getDamageMessage(damage));
    }
}
