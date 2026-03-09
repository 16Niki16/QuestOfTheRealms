package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.map.room.Chest;
import sofia.sap.interview.project.game.user.User;

public class OpenChestCommand implements Command {
    @Override
    public CommandResult execute(User user) {
        GameSession session = user.getSession();
        Chest chest = session.gameplay().getChestOnCharacterCoordinates();
        return session.combat().collect(session.character(), chest);
    }
}
