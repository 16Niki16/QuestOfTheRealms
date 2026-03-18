package sofia.sap.interview.project.game.view;

import sofia.sap.interview.project.game.events.QuestCompletedEvent;

public class QuestCompletedView implements GameEventView<QuestCompletedEvent> {
    @Override
    public void render(QuestCompletedEvent event) {
        String type = event.dto().type().name().toLowerCase().replace('_', ' ');
        String formatted = String.format("Congrats you completed quest: %s(%s)", type, event.dto().description());
        System.out.println(formatted);
    }
}
