package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.CommandResult;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.items.ItemType;

public class UseItemCommand implements Command {
    private final GameSession context;
    private final ItemType item;

    public UseItemCommand(GameSession context, ItemType item) {
        this.context = context;
        this.item = item;
    }

    @Override
    public CommandResult execute() {
        return this.context.combat().useItem(this.context.character(), this.item);
    }
}
