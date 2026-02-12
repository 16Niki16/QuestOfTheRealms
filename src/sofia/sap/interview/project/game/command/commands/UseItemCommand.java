package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.CommandResult;
import sofia.sap.interview.project.game.command.GameContext;
import sofia.sap.interview.project.game.inventory.Item;

public class UseItemCommand implements Command {
    private final GameContext context;
    private final String item;

    public UseItemCommand(GameContext context, String item) {
        this.context = context;
        this.item = item;
    }

    @Override
    public CommandResult execute() {
        Item itemType = Item.getItem(item);
        this.context.character().applyPotion(itemType);

        return new CommandResult(getItemEffectMessage(itemType));
    }

    private String getItemEffectMessage(Item item) {
        return String.format("Your item provided you with %d %s!", item.getEffect(), item.getSource());
    }
}
