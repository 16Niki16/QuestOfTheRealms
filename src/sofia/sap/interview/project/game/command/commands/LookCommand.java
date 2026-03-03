package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.command.result.ViewResult;
import sofia.sap.interview.project.game.gameplay.GameSession;

public class LookCommand implements Command {
    private final GameSession context;

    public LookCommand(GameSession context) {
        this.context = context;
    }

    @Override
    public CommandResult execute() {
        return new ViewResult(this.context.gameplay().lookAround());
    }
}
