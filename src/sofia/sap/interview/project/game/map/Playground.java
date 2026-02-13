package sofia.sap.interview.project.game.map;

import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.inventory.Chest;
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

    /**
     * (0,0) x -->
     * y
     * |
     * raste nadolu
     */

    public boolean canMove(Coordinates playerPosition, Direction direction) {
        Coordinates next = direction.move(playerPosition);
        return isInside(next);
    }

    public Set<Direction> possibleDirections(Coordinates playerCoordinates) {
        Set<Direction> directions = new HashSet<>();

        for (Direction direction : Direction.values()) {
            Coordinates next = direction.move(playerCoordinates);
            if (isInside(next)) {
                directions.add(direction);
            }
        }
        return directions;
    }

    private boolean isInside(Coordinates c) {
        return c.y() >= 0 && c.y() < rooms.length
            && c.x() >= 0 && c.x() < rooms[c.y()].length;
    }

    public Enemy getEnemyByPosition(Coordinates coordinates) {
        return rooms[coordinates.x()][coordinates.y()].enemy();
    }

    public Chest getChestByPosition(Coordinates coordinates) {
        return rooms[coordinates.x()][coordinates.y()].chest();
    }
}
