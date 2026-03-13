package sofia.sap.interview.project.game.files;

import com.google.gson.Gson;
import sofia.sap.interview.project.game.exceptions.NewGameFileException;
import sofia.sap.interview.project.game.user.User;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;

public class LoadGame {
    public static User loadGame(String username) {
        Path path = Path.of("files", username + ".json");
        Gson gson = new Gson();

        try (Reader reader = Files.newBufferedReader(path)) {
            return gson.fromJson(reader, User.class);

        } catch (IOException e) {
            throw new NewGameFileException("Failed to load playground", e);
        }
    }
}
