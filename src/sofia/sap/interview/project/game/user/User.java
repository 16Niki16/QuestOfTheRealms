package sofia.sap.interview.project.game.user;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.files.NewGame;
import sofia.sap.interview.project.game.gameplay.CombatService;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.gameplay.GameState;
import sofia.sap.interview.project.game.gameplay.Gameplay;
import sofia.sap.interview.project.game.quests.QuestLog;

public class User {
    private String username;
    private GameSession session;

    private User(String username, GameSession session) {
        this.username = username;
        this.session = session;
    }

    public static User createUser(String username) {
        return new User(username, null);
    }

    public void createNewGame(String name, AllyCharacterType type) {
        Gameplay gameplay = new Gameplay(NewGame.createPlayground());
        Character character = new Character(name, type);
        QuestLog log = new QuestLog();
        CombatService actions = new CombatService();
        this.session = new GameSession(gameplay, character, log, actions, GameState.RUNNING);
    }
}
