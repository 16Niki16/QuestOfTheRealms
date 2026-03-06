package sofia.sap.interview.project.game.view;

import sofia.sap.interview.project.game.events.AttackEvent;

public class AttackView implements GameEventView<AttackEvent> {
    @Override
    public void render(AttackEvent event) {
        String formatted = String.format("Your %s dealt %d damage to the enemy %s",
            event.characterName(), event.damage(), event.type().getName());
    }
}
