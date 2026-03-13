package sofia.sap.interview.project.game.files;

import com.fasterxml.jackson.databind.ObjectMapper;
import sofia.sap.interview.project.game.dto.loadgame.GameSessionFactory;
import sofia.sap.interview.project.game.dto.savegame.data.GameData;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.quests.QuestLog;
import sofia.sap.interview.project.game.user.User;

import java.io.IOException;
import java.nio.file.Path;

public class LoadGame {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /*public static void loadGame(User user) {

        Path path = Path.of("files", user.getUsername() + ".json");

        try {

            GameData data = MAPPER.readValue(path.toFile(), GameData.class);

            GameSession session = GameSessionFactory.create(data.getMap(), data.getCharacter());
            QuestLog log = QuestLogFactory.create(data.getQuests());

            user.setSession(session);
            user.setLog(log);

        } catch (IOException e) {
            throw new RuntimeException("Failed to load game", e);
        }
    }*/
}
