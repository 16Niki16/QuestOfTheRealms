package sofia.sap.interview.project.game.systems;

import sofia.sap.interview.project.game.characters.enemy.EnemyState;
import sofia.sap.interview.project.game.command.commands.EnemyAttackCommand;
import sofia.sap.interview.project.game.map.room.Room;
import sofia.sap.interview.project.game.user.User;

import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EnemyAutoAttackSystem implements GameSystem {
    private static final int TIME_INTERVAL = 1;

    @Override
    public void start(ScheduledExecutorService scheduler, Set<User> activeUsers) {
        scheduler.scheduleAtFixedRate(() -> {
            for (User user : activeUsers) {
                Room room = user.getSession().gameplay().getRoom();
                if (room.hasEnemy()) {
                    EnemyState state = room.getState();
                    if (state.canAttack()) {
                        new EnemyAttackCommand().execute(user);
                        state.attacked();
                    }
                }
            }
        }, TIME_INTERVAL, TIME_INTERVAL, TimeUnit.SECONDS);
    }
}
