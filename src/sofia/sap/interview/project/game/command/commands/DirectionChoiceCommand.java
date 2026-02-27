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
    public CommandResult execute() {
        Set<Direction> possibleDirections = context.gameplay().getPossibleDirections();

        StringBuilder outputBuilder = new StringBuilder("The possible directions are: ");
        for (Direction direction : possibleDirections) {
            outputBuilder.append(direction).append(",");
        }

        return CommandResult.withoutEvent(outputBuilder.substring(0, outputBuilder.length() - 1));
    }
}
