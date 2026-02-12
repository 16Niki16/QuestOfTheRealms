package sofia.sap.interview.project.game.gameplay;

import com.google.gson.Gson;
import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.exceptions.DirectionNotAvailableException;
import sofia.sap.interview.project.game.inventory.Chest;
import sofia.sap.interview.project.game.map.Playground;
import sofia.sap.interview.project.game.map.cooridnates.Coordinates;
import sofia.sap.interview.project.game.map.directions.Direction;
import sofia.sap.interview.project.game.map.dto.PlaygroundDTO;
import sofia.sap.interview.project.game.map.dto.mappers.PlaygroundMapper;

import java.io.FileReader;
import java.util.Set;

public class Gameplay {
    private final Playground playground;
    private Coordinates playerCoordinates;

    public Gameplay(Character character) {
        this.playground = loadPlayground();
        this.playerCoordinates = Coordinates.startingCoordinates();
    }

    private Playground loadPlayground() {
        try {
            Gson gson = new Gson();

            FileReader reader = new FileReader("files\\CommonMap.json");

            PlaygroundDTO dto = gson.fromJson(reader, PlaygroundDTO.class);

            return PlaygroundMapper.map(dto);

        } catch (Exception e) {
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

    public Set<Direction> getPossibleDirections() {
        return this.playground.possibleDirections(this.playerCoordinates);
    }

    public Enemy getEnemyOnCharacterCoordinates() {
        return playground.getEnemyByPosition(playerCoordinates);
    }

    public Chest getChestOnCharacterCoordinates() {
        return playground.getChestByPosition(playerCoordinates);
    }
}
