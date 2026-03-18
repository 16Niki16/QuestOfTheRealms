package sofia.sap.interview.project.game.user;

import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.dto.loadgame.LoadedInformation;
import sofia.sap.interview.project.game.events.GameEvent;
import sofia.sap.interview.project.game.files.LoadGame;
import sofia.sap.interview.project.game.gameplay.GameFactory;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.quests.QuestLog;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class User {
    private final String username;
    private boolean activeSession;
    private GameSession session;
    private QuestLog log;
    private final Queue<GameEvent> eventQueue;

    private User(String username, GameSession session, QuestLog log, boolean activeSession) {
        this.username = username;
        this.session = session;
        this.log = log;
        this.activeSession = activeSession;
        this.eventQueue = new ConcurrentLinkedQueue<>();
    }

    public boolean isActiveSession() {
        return this.activeSession;
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
        return new User(username, null, null, false);
    }

    public void createNewGame(String name, AllyCharacterType type) {
        this.log = new QuestLog();
        this.session = GameFactory.createSession(name, type);
        this.activeSession = true;
    }

    public void processEvents() {
        GameEvent event;
        while ((event = eventQueue.poll()) != null) {
            handleEvent(event);
        }
    }

    public boolean handleEvent(GameEvent event) {
        if (log == null) {
            return false;
        }
        return log.handleEvent(event);
    }

    public void endGame() {
        this.activeSession = false;
        this.session = null;
        this.log = null;
    }

    public void loadGame() {
        LoadedInformation info = LoadGame.loadGame(this.username);
        this.session = info.session();
        this.log = info.log();
        this.activeSession = true;
    }

    public void addEvents(List<GameEvent> events) {
        this.eventQueue.addAll(events);
    }
}
