package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.command.result.ViewResult;
import sofia.sap.interview.project.game.information.PossibleDirectionInformation;
import sofia.sap.interview.project.game.map.Direction;
import sofia.sap.interview.project.game.user.User;

import java.util.Set;

public class DirectionChoiceCommand implements Command {
    private final User user;

    public DirectionChoiceCommand(User user) {
        this.user = user;
    }

    @Override
    public CommandResult execute() {
        Set<Direction> possibleDirections = this.user.getSession().gameplay().getPossibleDirections();

        return new ViewResult(new PossibleDirectionInformation(possibleDirections));
    }
}
