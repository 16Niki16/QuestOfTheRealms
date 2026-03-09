package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.user.User;

public class LookCommand implements Command {
    private final User user;

    public LookCommand(User user) {
        this.user = user;
    }

    @Override
    public CommandResult execute() {
        GameSession session = this.user.getSession();
        return session.gameplay().lookAround(this.user);
    }
}
