package sofia.sap.interview.project.game;

import sofia.sap.interview.project.game.systems.SystemsStarter;
import sofia.sap.interview.project.game.user.User;

import java.util.HashSet;
import java.util.Set;

public class GameController {
    private final Set<User> users;
    private final SystemsStarter starter;

    public GameController() {
        this.users = new HashSet<>();
        this.starter = new SystemsStarter(this.users);
        starter.start();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void closeServer() {
        this.starter.stop();
    }
}
