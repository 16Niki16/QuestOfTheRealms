package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.user.User;

public class LookCommand implements Command {
    @Override
    public CommandResult execute(User user) {
        GameSession session = user.getSession();
        return session.gameplay().lookAround(user);
    }
}
