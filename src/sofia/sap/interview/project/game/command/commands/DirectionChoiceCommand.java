package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.command.result.ViewResult;
import sofia.sap.interview.project.game.information.PossibleDirectionInformation;
import sofia.sap.interview.project.game.map.Direction;
import sofia.sap.interview.project.game.user.User;

import java.util.Set;

public class DirectionChoiceCommand implements Command {
    @Override
    public CommandResult execute(User user) {
        Set<Direction> possibleDirections = user.getSession().gameplay().getPossibleDirections();

        return new ViewResult(new PossibleDirectionInformation(possibleDirections));
    }
}
