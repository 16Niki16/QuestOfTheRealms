package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.CommandResult;
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
        return CommandResult.withoutEvent("You successfully entered a new room!");
    }
}
