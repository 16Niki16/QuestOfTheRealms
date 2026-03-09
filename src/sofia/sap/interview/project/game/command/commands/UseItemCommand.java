package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.items.ItemType;
import sofia.sap.interview.project.game.user.User;

public class UseItemCommand implements Command {
    private final ItemType item;

    public UseItemCommand(ItemType item) {
        this.item = item;
    }

    @Override
    public CommandResult execute(User user) {
        GameSession session = user.getSession();
        return session.combat().useItem(session.character(), this.item);
    }
}
