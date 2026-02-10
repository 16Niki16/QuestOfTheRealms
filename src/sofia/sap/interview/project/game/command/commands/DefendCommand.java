package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.command.CommandResult;
import sofia.sap.interview.project.game.command.GameContext;

public class DefendCommand implements Command {
    private final GameContext context;

    public DefendCommand(GameContext context) {
        this.context = context;
    }

    @Override
    public CommandResult execute() {
        Enemy enemy = context.gameplay().getEnemyOnCharacterCoordinates();
        int damage = enemy.attackDamage();
        this.context.character().defendAgainstEnemy(damage);

        return new CommandResult(enemy.getDamageMessage(damage));
    }
}
