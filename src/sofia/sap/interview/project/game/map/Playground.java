package sofia.sap.interview.project.game.map;

import sofia.sap.interview.project.game.map.cooridnates.Coordinates;
import sofia.sap.interview.project.game.map.directions.Direction;
import sofia.sap.interview.project.game.map.room.Room;

import java.util.HashSet;
import java.util.Set;

public class Playground {
    private final Room[][] rooms;

    public Playground(Room[][] rooms) {
        this.rooms = rooms;
    }

    public Set<Direction> getPossibleDirections(Coordinates coordinates) {
        Set<Direction> directions = new HashSet<>();

        if (coordinates.coordinateY() + 1 <= this.rooms.length) {
            directions.add(Direction.SOUTH);
        }
        if (coordinates.coordinateY() - 1 >= 0) {
            directions.add(Direction.NORTH);
        }
        if (coordinates.coordinateX() + 1 <= this.rooms[coordinates.coordinateX()].length) {
            directions.add(Direction.EAST);
        }
        if (coordinates.coordinateX() - 1 >= 0) {
            directions.add(Direction.WEST);
        }
        return directions;
    }
}
