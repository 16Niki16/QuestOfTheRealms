package sofia.sap.interview.project.game.view;

import sofia.sap.interview.project.game.events.CharacterDiedEvent;

public class CharacterDiedView implements GameEventView<CharacterDiedEvent> {
    @Override
    public void render(CharacterDiedEvent event) {
        String formattedResponse = String.format("Your character %s has died", event.character().getCharacterName());
        System.out.println(formattedResponse);
    }
}
