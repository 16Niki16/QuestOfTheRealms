package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.CommandResult;
import sofia.sap.interview.project.game.command.GameContext;
import sofia.sap.interview.project.game.inventory.items.Collectable;
import sofia.sap.interview.project.game.inventory.items.Item;
import sofia.sap.interview.project.game.inventory.items.potions.Potion;

public class UseItemCommand implements Command {
    private final GameContext context;
    private final Collectable item;

    public UseItemCommand(GameContext context, Collectable item) {
        this.context = context;
        this.item = item;
    }

    @Override
    public CommandResult execute() {
        this.context.character().applyPotion((Potion) this.item);
        return new CommandResult(this.context.character().getItemEffectMessage((Item) this.item));
    }
}
