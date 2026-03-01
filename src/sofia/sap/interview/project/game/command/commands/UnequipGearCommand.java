package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.CommandResult;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.items.ItemType;

public class UnequipGearCommand implements Command {
    private final GameSession context;
    private final ItemType gear;

    public UnequipGearCommand(GameSession context, ItemType gear) {
        this.context = context;
        this.gear = gear;
    }

    @Override
    public CommandResult<String> execute() {
        return this.context.combat().unequip(this.context.character(), gear);
    }
}
