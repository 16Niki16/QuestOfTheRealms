package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.CommandResult;
import sofia.sap.interview.project.game.command.GameContext;

public class EquipGearCommand implements Command {
    private GameContext context;

    public EquipGearCommand(GameContext context) {
        this.context = context;
    }

    @Override
    public CommandResult execute() {
        return null;
    }
}
