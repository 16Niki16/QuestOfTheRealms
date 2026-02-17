package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.CommandResult;
import sofia.sap.interview.project.game.command.GameContext;
import sofia.sap.interview.project.game.map.Direction;

public class MoveCommand implements Command {
    private final GameContext context;
    private final Direction direction;

    public MoveCommand(GameContext context, Direction direction) {
        this.context = context;
        this.direction = direction;
    }

    @Override
    public CommandResult execute() {
        this.context.gameplay().movePlayer(this.direction);
        return new CommandResult("You successfully entered a new room!");
    }
}
