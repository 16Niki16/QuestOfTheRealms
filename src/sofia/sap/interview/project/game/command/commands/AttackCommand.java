package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.CommandResult;
import sofia.sap.interview.project.game.command.GameContext;

public class AttackCommand implements Command {
    private final GameContext context;

    public AttackCommand(GameContext context) {
        this.context = context;
    }

    @Override
    public CommandResult execute() {
        int damage = context.character().attackEnemy();
        context.gameplay().getEnemyOnCharacterCoordinates().defendAgainstAllyCharacter(damage);
        return new CommandResult(damageMessage(damage));
    }

    private String damageMessage(int damage) {
        return String.format("Your attack caused %d damage!", damage);
    }
}
