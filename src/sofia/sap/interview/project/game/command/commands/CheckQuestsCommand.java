package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.gameplay.GameSession;

public class CheckQuestsCommand implements Command {
    private final GameSession context;

    public CheckQuestsCommand(GameSession context) {
        this.context = context;
    }

    @Override
    public CommandResult<Void> execute() {
        return CommandResult.messageResult(context.log().questsStatus());
    }
}
