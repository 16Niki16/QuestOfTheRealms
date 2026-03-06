package sofia.sap.interview.project.game.files;

import com.google.gson.Gson;
import sofia.sap.interview.project.game.dto.PlaygroundDTO;
import sofia.sap.interview.project.game.dto.mappers.PlaygroundMapper;
import sofia.sap.interview.project.game.exceptions.NewGameFileException;
import sofia.sap.interview.project.game.map.Playground;

import java.io.FileReader;
import java.io.IOException;

public class NewGame {
    public static Playground createPlayground() {
        Gson gson = new Gson();

        try (FileReader reader = new FileReader("files\\CommonMap.json");) {
            PlaygroundDTO dto = gson.fromJson(reader, PlaygroundDTO.class);
            return PlaygroundMapper.map(dto);

        } catch (IOException e) {
            throw new NewGameFileException("Failed to load playground", e);
        }
    }
}
