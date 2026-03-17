package sofia.sap.interview.project.game;

import sofia.sap.interview.project.game.user.User;

import java.util.HashSet;
import java.util.Set;

public class GameController {
    private final Set<User> games;

    public GameController() {
        this.games = new HashSet<>();
    }

    public void addUser(User user) {
        games.add(user);
    }

    public String commandResolver(String userInput) {
        return null;
    }
}
