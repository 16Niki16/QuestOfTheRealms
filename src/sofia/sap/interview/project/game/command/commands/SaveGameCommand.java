package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.user.User;

public class SaveGameCommand implements Command {
    private final User user;

    public SaveGameCommand(User user) {
        this.user = user;
    }

    @Override
    public CommandResult execute() {
        return null;
    }
}
