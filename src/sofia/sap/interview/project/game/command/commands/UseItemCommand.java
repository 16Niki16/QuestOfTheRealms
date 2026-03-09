package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.items.ItemType;
import sofia.sap.interview.project.game.user.User;

public class UseItemCommand implements Command {
    private final User user;
    private final ItemType item;

    public UseItemCommand(User user, ItemType item) {
        this.user = user;
        this.item = item;
    }

    @Override
    public CommandResult execute() {
        GameSession session = this.user.getSession();
        return session.combat().useItem(session.character(), this.item);
    }
}
