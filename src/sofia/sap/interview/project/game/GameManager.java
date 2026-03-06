package sofia.sap.interview.project.game;

import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.user.User;

import java.util.HashMap;
import java.util.Map;

public class GameManager {
    private final Map<User, GameSession> games;

    public GameManager() {
        this.games = new HashMap<>();
    }

    public void addUser(User user) {
        if (!games.containsKey(user)) {
            games.put(user, null);
        }
    }
}
