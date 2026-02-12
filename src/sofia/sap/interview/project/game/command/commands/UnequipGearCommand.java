package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.CommandResult;
import sofia.sap.interview.project.game.command.GameContext;
import sofia.sap.interview.project.game.inventory.Item;

public class UnequipGearCommand implements Command {
    private final GameContext context;
    private final String gear;

    public UnequipGearCommand(GameContext context, String gear) {
        this.context = context;
        this.gear = gear;
    }

    @Override
    public CommandResult execute() {
        Item item = Item.getItem(gear);
        this.context.character().unequipGear(item);

        return new CommandResult(String.format("The %s is successfully unequipped!", gear));
    }
}
