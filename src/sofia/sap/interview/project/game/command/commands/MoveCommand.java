package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.command.result.EventResult;
import sofia.sap.interview.project.game.events.CharacterMovedEvent;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.map.Direction;

public class MoveCommand implements Command {
    private final GameSession context;
    private final Direction direction;

    public MoveCommand(GameSession context, Direction direction) {
        this.context = context;
        this.direction = direction;
    }

    @Override
    public CommandResult execute() {
        this.context.gameplay().movePlayer(this.direction);
        return new EventResult(
            CharacterMovedEvent.movedEvent(this.context.character(), this.context.gameplay().getRoom()));
    }
}
