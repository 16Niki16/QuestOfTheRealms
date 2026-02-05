package sofia.sap.interview.project.game.map;

import sofia.sap.interview.project.game.map.cooridnates.Coordinates;
import sofia.sap.interview.project.game.map.directions.Direction;
import sofia.sap.interview.project.game.map.room.Room;

import java.util.HashSet;
import java.util.Set;

public class Playground {
    private final Room[][] rooms;
    private Coordinates playerCoordinates;

    public Playground(Room[][] rooms) {
        this.playerCoordinates = Coordinates.startingCoordinates();
        this.rooms = rooms;
    }

    /**
     * (0,0) x -->
     * y
     * |
     * raste nadolu
     */

    public Set<Direction> getPossibleDirections() {
        Set<Direction> directions = new HashSet<>();

        for (Direction direction : Direction.values()) {
            Coordinates next = direction.move(playerCoordinates);
            if (isInside(next)) {
                directions.add(direction);
            }
        }

        return directions;
    }

    public void changePlayerPosition(Direction direction) {
        Coordinates next = direction.move(playerCoordinates);

        if (isInside(next)) {
            playerCoordinates = next;
        }
    }

    private boolean isInside(Coordinates c) {
        return c.y() >= 0 && c.y() < rooms.length
            && c.x() >= 0 && c.x() < rooms[c.y()].length;
    }
}
