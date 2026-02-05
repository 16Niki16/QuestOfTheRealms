package sofia.sap.interview.project.game.gameplay;

import com.google.gson.Gson;
import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.map.Playground;
import sofia.sap.interview.project.game.map.directions.Direction;
import sofia.sap.interview.project.game.map.dto.PlaygroundDTO;
import sofia.sap.interview.project.game.map.dto.mappers.PlaygroundMapper;

import java.io.FileReader;
import java.util.Set;

public class Gameplay {
    private Character character;
    private final Playground playground;

    public Gameplay(Character character) {
        this.character = character;
        this.playground = loadPlayground();
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

    public Set<Direction> getPossibleDirections() {
        return this.playground.getPossibleDirections();
    }
}
