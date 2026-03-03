package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.command.result.ViewResult;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.map.Direction;
import sofia.sap.interview.project.game.information.PossibleDirectionInformation;

import java.util.Set;

public class DirectionChoiceCommand implements Command {
    private final GameSession context;

    public DirectionChoiceCommand(GameSession context) {
        this.context = context;
    }

    @Override
    public CommandResult execute() {
        Set<Direction> possibleDirections = context.gameplay().getPossibleDirections();

        return new ViewResult(new PossibleDirectionInformation(possibleDirections));
    }
}
