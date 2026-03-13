package sofia.sap.interview.project.game.view;

import sofia.sap.interview.project.game.events.DefendEvent;

public class DefendView implements GameEventView<DefendEvent> {
    @Override
    public void render(DefendEvent event) {
        String formatted = String.format("%s dealt %d damage to your %s",
            event.dto().type(), event.dto().damage(), event.dto().characterName());
        System.out.println(formatted);
    }
}
