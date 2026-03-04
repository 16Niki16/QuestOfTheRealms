package sofia.sap.interview.project.game.console;

import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.command.result.EventResult;
import sofia.sap.interview.project.game.command.result.ViewResult;
import sofia.sap.interview.project.game.events.CharacterMovedEvent;
import sofia.sap.interview.project.game.events.GameEvent;
import sofia.sap.interview.project.game.events.KillEnemyEvent;
import sofia.sap.interview.project.game.information.HelpInformation;
import sofia.sap.interview.project.game.information.PossibleDirectionInformation;
import sofia.sap.interview.project.game.information.QuestInformation;
import sofia.sap.interview.project.game.information.RoomInformation;
import sofia.sap.interview.project.game.information.ViewInformation;
import sofia.sap.interview.project.game.view.CharacterMovedView;
import sofia.sap.interview.project.game.view.EnemyKilledView;
import sofia.sap.interview.project.game.view.GameEventView;
import sofia.sap.interview.project.game.view.HelpView;
import sofia.sap.interview.project.game.view.PossibleDirectionView;
import sofia.sap.interview.project.game.view.QuestView;
import sofia.sap.interview.project.game.view.RoomView;
import sofia.sap.interview.project.game.view.StatelessCommandView;

import java.util.HashMap;
import java.util.Map;

public class ConsoleRenderer {
    private final Map<Class<? extends GameEvent>, GameEventView<?>> eventViews;
    private final Map<Class<?>, StatelessCommandView<?>> basicViews;

    public ConsoleRenderer() {
        this.eventViews = new HashMap<>();
        this.eventViews.put(CharacterMovedEvent.class, new CharacterMovedView());
        this.eventViews.put(KillEnemyEvent.class, new EnemyKilledView());

        this.basicViews = new HashMap<>();
        this.basicViews.put(HelpInformation.class, new HelpView());
        this.basicViews.put(PossibleDirectionInformation.class, new PossibleDirectionView());
        this.basicViews.put(QuestInformation.class, new QuestView());
        this.basicViews.put(RoomInformation.class, new RoomView());

    }

    public void render(CommandResult result) {
        if (result instanceof EventResult eventResult) {
            GameEvent event = eventResult.event();
            GameEventView view = this.eventViews.get(event.getClass());
            view.render(event);
        } else if (result instanceof ViewResult viewResult) {
            ViewInformation information = viewResult.information();
            StatelessCommandView view = this.basicViews.get(information.getClass());
            view.render(information);
        }
    }
}
