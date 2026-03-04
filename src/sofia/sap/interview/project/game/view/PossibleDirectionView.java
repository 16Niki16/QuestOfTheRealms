package sofia.sap.interview.project.game.view;

import sofia.sap.interview.project.game.information.PossibleDirectionInformation;
import sofia.sap.interview.project.game.map.Direction;

import java.util.Set;

public class PossibleDirectionView implements ViewCommand<PossibleDirectionInformation> {
    @Override
    public void render(PossibleDirectionInformation information) {
        Set<Direction> directions = information.directions();
        System.out.println("The possible directions to continue your adventure are:");
        for (Direction direction : directions) {
            System.out.println(direction);
        }
    }
}
