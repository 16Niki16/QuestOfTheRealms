package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.CommandResult;
import sofia.sap.interview.project.game.command.GameContext;

public class MoveCommand implements Command {
    private GameContext context;

    public MoveCommand(GameContext context) {
        this.context = context;
    }

    @Override
    public CommandResult execute() {
        return null;
    }
}
