package sofia.sap.interview.project.game.view;

import sofia.sap.interview.project.game.map.Direction;

import java.util.Set;

public record PossibleDirectionInformation(Set<Direction> directions) implements ViewInformation{
}
