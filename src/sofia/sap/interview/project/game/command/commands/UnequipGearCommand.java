package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.CommandResult;
import sofia.sap.interview.project.game.gameplay.GameContext;
import sofia.sap.interview.project.game.items.Gear;

public class UnequipGearCommand implements Command {
    private final GameContext context;
    private final Gear gear;

    public UnequipGearCommand(GameContext context, Gear gear) {
        this.context = context;
        this.gear = gear;
    }

    @Override
    public CommandResult execute() {
        this.context.character().unequipGear(gear);

        return CommandResult.withoutEvent(this.gear.unequipMessage());
    }
}
