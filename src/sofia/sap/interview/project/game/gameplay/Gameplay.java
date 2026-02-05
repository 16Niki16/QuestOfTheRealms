package sofia.sap.interview.project.game.gameplay;

import com.google.gson.Gson;
import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.map.Playground;
import sofia.sap.interview.project.game.map.dto.PlaygroundDTO;
import sofia.sap.interview.project.game.map.dto.mappers.PlaygroundMapper;

import java.io.FileReader;

public class Gameplay {
    private Character character;
    private Playground playground;

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

    public Playground getPlayground() {
        return this.playground;
    }
}
