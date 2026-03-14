package sofia.sap.interview.project.game.user;

import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.dto.loadgame.LoadedInformation;
import sofia.sap.interview.project.game.events.GameEvent;
import sofia.sap.interview.project.game.exceptions.InvalidSessionException;
import sofia.sap.interview.project.game.files.LoadGame;
import sofia.sap.interview.project.game.gameplay.GameFactory;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.gameplay.GameState;
import sofia.sap.interview.project.game.quests.QuestLog;

public class User {
    private String username;
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
            throw new IllegalArgumentException("The log is null!");
        }
        return log.handleEvent(event);
    }

    public void endGame() {
        if (session.state().equals(GameState.GAME_OVER)) {
            this.session = null;
            this.log = null;
        }
    }

    public void loadGame() {
        LoadedInformation info = LoadGame.loadGame(this.username);
        if (info.session().state().equals(GameState.GAME_OVER)) {
            throw new InvalidSessionException("The loaded game is already over, start a new one");
        }
        this.session = info.session();
        this.log = info.log();
    }
}
