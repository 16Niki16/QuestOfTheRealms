package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.command.CommandResult;
import sofia.sap.interview.project.game.command.GameContext;
import sofia.sap.interview.project.game.inventory.Chest;

public class LookCommand implements Command {
    private final GameContext context;

    public LookCommand(GameContext context) {
        this.context = context;
    }

    @Override
    public CommandResult execute() {
        Chest chest = this.context.gameplay().getChestOnCharacterCoordinates();
        Enemy enemy = this.context.gameplay().getEnemyOnCharacterCoordinates();

        StringBuilder contain = new StringBuilder("The room contains:\n");
        if (chest != null) {
            contain.append("- Chest\n");
        }
        if (enemy != null) {
            contain.append("- Enemy");
        }
        return new CommandResult(contain.toString());
    }
}
