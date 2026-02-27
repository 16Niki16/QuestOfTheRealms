package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.CommandResult;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.map.Direction;

import java.util.Set;

public class DirectionChoiceCommand implements Command {
    private final GameSession context;

    public DirectionChoiceCommand(GameSession context) {
        this.context = context;
    }

    @Override
    public CommandResult<Set<Direction>> execute() {
        Set<Direction> possibleDirections = context.gameplay().getPossibleDirections();

        return CommandResult.withObject(possibleDirections);
    }
}
