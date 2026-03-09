package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.items.ItemType;
import sofia.sap.interview.project.game.user.User;

public class EquipGearCommand implements Command {
    private final User user;
    private final ItemType gear;

    public EquipGearCommand(User user, ItemType gear) {
        this.user = user;
        this.gear = gear;
    }

    @Override
    public CommandResult execute() {
        GameSession session = this.user.getSession();
        return session.combat().equip(session.character(), this.gear);
    }
}
