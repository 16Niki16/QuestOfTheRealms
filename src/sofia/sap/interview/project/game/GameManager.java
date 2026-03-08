package sofia.sap.interview.project.game;

import sofia.sap.interview.project.game.exceptions.UserNotKnownException;
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

    public void addSession(User user, GameSession session) {
        if (!games.containsKey(user)) {
            throw new UserNotKnownException("You can not initialize session with the provided user!");
        }
        games.put(user, session);
    }
}
