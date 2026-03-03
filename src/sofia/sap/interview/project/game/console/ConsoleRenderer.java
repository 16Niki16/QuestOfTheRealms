package sofia.sap.interview.project.game.console;

import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.command.result.EventResult;
import sofia.sap.interview.project.game.command.result.ViewResult;
import sofia.sap.interview.project.game.events.CharacterMovedEvent;
import sofia.sap.interview.project.game.events.GameEvent;
import sofia.sap.interview.project.game.events.KillEnemyEvent;
import sofia.sap.interview.project.game.view.View;

import java.util.HashMap;
import java.util.Map;

public class ConsoleRenderer {
    private final Map<Class<? extends GameEvent>, GameEventView<?>> eventViews;
    private final Map<Class<?>, View<?>> basicViews;

    public ConsoleRenderer() {
        this.eventViews = new HashMap<>();
        this.eventViews.put(CharacterMovedEvent.class, new CharacterMovedView());
        this.eventViews.put(KillEnemyEvent.class, new EnemyKilledView());

        this.basicViews = new HashMap<>();
    }

    public void render(CommandResult result) {
        if (result instanceof EventResult eventResult) {
            GameEvent event = eventResult.event();
            GameEventView<?> view = this.eventViews.get(event.getClass());
            view.render(event);
        } else {
            ViewResult view = views.get(event.getClass());
            if (view != null) {
                view.render(event);
            }
        }


    }
}
