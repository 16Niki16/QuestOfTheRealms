package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.CommandResult;
import sofia.sap.interview.project.game.command.GameContext;

public class CheckQuestsCommand implements Command {
    private final GameContext context;

    public CheckQuestsCommand(GameContext context) {
        this.context = context;
    }

    @Override
    public CommandResult execute() {
        return CommandResult.withoutEvent(context.log().questsStatus());
    }
}
