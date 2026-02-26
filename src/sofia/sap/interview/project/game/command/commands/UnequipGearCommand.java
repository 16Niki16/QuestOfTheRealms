package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.CommandResult;
import sofia.sap.interview.project.game.gameplay.GameContext;
import sofia.sap.interview.project.game.items.Gear;
import sofia.sap.interview.project.game.items.ItemType;

public class UnequipGearCommand implements Command {
    private final GameContext context;
    private final ItemType gear;

    public UnequipGearCommand(GameContext context, ItemType gear) {
        this.context = context;
        this.gear = gear;
    }

    @Override
    public CommandResult execute() {
        this.context.character().unequipGear(gear);

        return CommandResult.withoutEvent(this.gear.unequipMessage());
    }
}
