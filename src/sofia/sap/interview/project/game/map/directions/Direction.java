package sofia.sap.interview.project.game.map.directions;

import sofia.sap.interview.project.game.map.cooridnates.Coordinates;

public enum Direction {
    SOUTH(0, 1),
    NORTH(0, -1),
    EAST(1, 0),
    WEST(-1, 0);

    private final int dx;
    private final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public Coordinates move(Coordinates from) {
        return new Coordinates(from.x() + dx, from.y() + dy);
    }
}
