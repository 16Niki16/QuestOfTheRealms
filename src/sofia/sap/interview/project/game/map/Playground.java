package sofia.sap.interview.project.game.map;

import sofia.sap.interview.project.game.map.cooridnates.Coordinates;
import sofia.sap.interview.project.game.map.directions.Direction;
import sofia.sap.interview.project.game.map.room.Room;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashSet;
import java.util.Set;

public class Playground {
    private final Room[][] map;

    public Playground(Reader reader) {
        this.map = new Room[map.length][];

        for (int i = 0; i < map.length; i++) {
            this.map[i] = new Room[map[i].length];
            System.arraycopy(map[i], 0, this.map[i], 0, map[i].length);
        }
    }

    private void loadMapFromFile(Reader reader) {
        try (BufferedReader mapReader = new BufferedReader(reader)) {
            String line;
            while ((line = mapReader.readLine()) != null) {

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private

    public Set<Direction> getPossibleDirections(Coordinates coordinates) {
        Set<Direction> directions = new HashSet<>();

        if (coordinates.coordinateY() + 1 <= this.map.length) {
            directions.add(Direction.SOUTH);
        }
        if (coordinates.coordinateY() - 1 >= 0) {
            directions.add(Direction.NORTH);
        }
        if (coordinates.coordinateX() + 1 <= this.map[coordinates.coordinateX()].length) {
            directions.add(Direction.EAST);
        }
        if (coordinates.coordinateX() - 1 >= 0) {
            directions.add(Direction.WEST);
        }
        return directions;
    }
}
