package sofia.sap.interview.project.game.view;

import sofia.sap.interview.project.game.events.CharacterDamagedEvent;

public class CharacterDamagedView implements GameEventView<CharacterDamagedEvent> {
    @Override
    public void render(CharacterDamagedEvent event) {
        String formatted = String.format("Your %s dealt %d damage to the enemy %s",
                event.characterName(), event.damage(), event.type().getName());
    }
}
