package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.CommandResult;
import sofia.sap.interview.project.game.command.GameContext;
import sofia.sap.interview.project.game.map.Direction;

import java.util.Set;

public class DirectionChoiceCommand implements Command {
    private final GameContext context;

    public DirectionChoiceCommand(GameContext context) {
        this.context = context;
    }

    @Override
    public CommandResult execute() {
        Set<Direction> possibleDirections = context.gameplay().getPossibleDirections();

        StringBuilder outputBuilder = new StringBuilder("The possible directions are: ");
        for (Direction direction : possibleDirections) {
            outputBuilder.append(direction).append(",");
        }

        return new CommandResult(outputBuilder.substring(0, outputBuilder.length() - 1));
    }
}
