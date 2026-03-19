package sofia.sap.interview.project.game.systems;

import sofia.sap.interview.project.game.console.ConsoleRenderer;
import sofia.sap.interview.project.game.user.User;

import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

public class EventsHandleSystem implements GameSystem {
    private static final ConsoleRenderer RENDERER = new ConsoleRenderer();

    @Override
    public void start(ScheduledExecutorService scheduler, Set<User> activeUsers) {
       /* scheduler.scheduleAtFixedRate(() -> {
            for (User user : activeUsers) {
                user.processEvents();
            }
        })*/
    }
}
