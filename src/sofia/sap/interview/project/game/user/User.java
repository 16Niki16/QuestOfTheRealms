package sofia.sap.interview.project.game.user;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.events.GameEvent;
import sofia.sap.interview.project.game.files.NewGame;
import sofia.sap.interview.project.game.gameplay.CombatService;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.gameplay.GameState;
import sofia.sap.interview.project.game.gameplay.Gameplay;
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

    public static User createUser(String username) {
        return new User(username, null, null);
    }

    public void createNewGame(String name, AllyCharacterType type) {
        Gameplay gameplay = new Gameplay(NewGame.createPlayground());
        Character character = new Character(name, type);
        this.log = new QuestLog();
        CombatService actions = new CombatService();
        this.session = new GameSession(gameplay, character, actions, GameState.RUNNING);
    }

    public void handleEvent(GameEvent event) {
        log.handleEvent(event);
    }

    public void endGame() {
        if (session.state().equals(GameState.GAME_OVER)) {
            this.session = null;
            this.log = null;
        }
    }
}
