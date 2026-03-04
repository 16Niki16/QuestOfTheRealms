package sofia.sap.interview.project.game.gameplay;

import com.google.gson.Gson;
import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;
import sofia.sap.interview.project.game.dto.PlaygroundDTO;
import sofia.sap.interview.project.game.dto.mappers.PlaygroundMapper;
import sofia.sap.interview.project.game.exceptions.DirectionNotAvailableException;
import sofia.sap.interview.project.game.information.RoomInformation;
import sofia.sap.interview.project.game.map.Coordinates;
import sofia.sap.interview.project.game.map.Direction;
import sofia.sap.interview.project.game.map.Playground;
import sofia.sap.interview.project.game.map.room.Chest;
import sofia.sap.interview.project.game.map.room.Room;
import sofia.sap.interview.project.game.map.room.SpecialItem;

import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

public class Gameplay {
    private final Playground playground;
    private Coordinates playerCoordinates;

    public Gameplay() {
        this.playground = loadPlayground();
        this.playerCoordinates = Coordinates.startingCoordinates();
    }

    private Playground loadPlayground() {
        Gson gson = new Gson();

        try (FileReader reader = new FileReader("files\\CommonMap.json");) {
            PlaygroundDTO dto = gson.fromJson(reader, PlaygroundDTO.class);
            return PlaygroundMapper.map(dto);

        } catch (IOException e) {
            throw new RuntimeException("Failed to load playground", e);
        }
    }

    public void movePlayer(Direction direction) {
        if (playground.canMove(this.playerCoordinates, direction)) {
            this.playerCoordinates = direction.move(this.playerCoordinates);
        } else {
            throw new DirectionNotAvailableException(
                    "The provided direction is not correct, choose another direction!");
        }
    }

    public RoomInformation lookAround() {
        Enemy enemy = getEnemyOnCharacterCoordinates();
        EnemyType enemyType = enemy != null ? enemy.getType() : null;

        return new RoomInformation(getChestOnCharacterCoordinates() != null,
                enemyType, getSpecialItemOnPlayerCoordinates());
    }

    public Set<Direction> getPossibleDirections() {
        return this.playground.possibleDirections(this.playerCoordinates);
    }

    public Enemy getEnemyOnCharacterCoordinates() {
        return playground.getEnemyByPosition(playerCoordinates);
    }

    public Chest getChestOnCharacterCoordinates() {
        return playground.getChestByPosition(playerCoordinates);
    }

    public SpecialItem getSpecialItemOnPlayerCoordinates() {
        return playground.getSpecialItemByPosition(playerCoordinates);
    }

    public Room getRoom() {
        return this.playground.getRoomByCoordinates(this.playerCoordinates);
    }
}
