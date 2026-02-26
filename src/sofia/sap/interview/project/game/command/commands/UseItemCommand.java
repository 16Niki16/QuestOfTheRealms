package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.CommandResult;
import sofia.sap.interview.project.game.gameplay.GameContext;
import sofia.sap.interview.project.game.items.ItemType;

public class UseItemCommand implements Command {
    private final GameContext context;
    private final ItemType item;

    public UseItemCommand(GameContext context, ItemType item) {
        this.context = context;
        this.item = item;
    }

    @Override
    public CommandResult execute() {
        return this.context.combat().useItem(this.context.character(), this.item);
    }
}
