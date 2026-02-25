package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.CommandResult;
import sofia.sap.interview.project.game.command.GameContext;
import sofia.sap.interview.project.game.items.Consumable;

public class UseItemCommand implements Command {
    private final GameContext context;
    private final Consumable item;

    public UseItemCommand(GameContext context, Consumable item) {
        this.context = context;
        this.item = item;
    }

    @Override
    public CommandResult execute() {
        this.context.character().applyPotion(this.item);

        return CommandResult.withoutEvent(this.item.itemMessage());
    }
}
