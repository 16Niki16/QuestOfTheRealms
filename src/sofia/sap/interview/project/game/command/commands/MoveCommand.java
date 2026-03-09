package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.command.result.EventResult;
import sofia.sap.interview.project.game.events.CharacterMovedEvent;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.map.Direction;
import sofia.sap.interview.project.game.user.User;

public class MoveCommand implements Command {
    private final User user;
    private final Direction direction;

    public MoveCommand(User user, Direction direction) {
        this.user = user;
        this.direction = direction;
    }

    @Override
    public CommandResult execute() {
        GameSession session = this.user.getSession();
        session.gameplay().movePlayer(this.direction);
        return new EventResult(
                CharacterMovedEvent.movedEvent(session.character(), session.gameplay().getRoom()));
    }
}
