package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.CommandResult;
import sofia.sap.interview.project.game.gameplay.GameContext;

public class UseItemCommand implements Command {
    private final GameContext context;
    private final String item;

    public UseItemCommand(GameContext context, String item) {
        this.context = context;
        this.item = item;
    }

    @Override
    public CommandResult execute() {
        return this.context.combat().useItem(this.context.character(), this.item);
    }
}
