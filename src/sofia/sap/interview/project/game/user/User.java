package sofia.sap.interview.project.game.user;

import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.dto.loadgame.LoadedInformation;
import sofia.sap.interview.project.game.events.GameEvent;
import sofia.sap.interview.project.game.files.LoadGame;
import sofia.sap.interview.project.game.gameplay.GameFactory;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.quests.QuestLog;

public class User {
    private final String username;
    private GameSession session;
    private QuestLog log;

    private User(String username, GameSession session, QuestLog log) {
        this.username = username;
        this.session = session;
        this.log = log;
    }

    public String getUsername() {
        return this.username;
    }

    public GameSession getSession() {
        return this.session;
    }

    public QuestLog getLog() {
        return this.log;
    }

    public static User createUser(String username) {
        return new User(username, null, null);
    }

    public void createNewGame(String name, AllyCharacterType type) {
        this.log = new QuestLog();
        this.session = GameFactory.createSession(name, type);
    }

    public boolean handleEvent(GameEvent event) {
        if (log == null) {
            throw new IllegalArgumentException("There is not active log yet!");
        }
        return log.handleEvent(event);
    }

    public void endGame() {
        this.session = null;
        this.log = null;
    }

    public void loadGame() {
        LoadedInformation info = LoadGame.loadGame(this.username);
        this.session = info.session();
        this.log = info.log();
    }
}
