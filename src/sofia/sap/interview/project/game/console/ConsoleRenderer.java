package sofia.sap.interview.project.game.console;

import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.events.CharacterMovedEvent;
import sofia.sap.interview.project.game.events.GameEvent;
import sofia.sap.interview.project.game.events.KillEnemyEvent;

import java.util.HashMap;
import java.util.Map;

public class ConsoleRenderer {
    private final Map<Class<? extends GameEvent>, GameEventView<?>> views;

    public ConsoleRenderer() {
        views = new HashMap<>();
        views.put(CharacterMovedEvent.class, new CharacterMovedView());
        views.put(KillEnemyEvent.class, new EnemyKilledView());
    }

    public void render(CommandResult result) {
        GameEvent event = result.event();
        if (event == null) return;

        EventView view = views.get(event.getClass());
        if (view != null) {
            view.render(event);
        }
    }
}
