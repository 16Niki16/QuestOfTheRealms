package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.items.ItemType;
import sofia.sap.interview.project.game.user.User;

public class UnequipGearCommand implements Command {
    private final User user;
    private final ItemType gear;

    public UnequipGearCommand(User user, ItemType gear) {
        this.user = user;
        this.gear = gear;
    }

    @Override
    public CommandResult execute() {
        GameSession session = this.user.getSession();
        return session.combat().unequip(session.character(), gear);
    }
}
