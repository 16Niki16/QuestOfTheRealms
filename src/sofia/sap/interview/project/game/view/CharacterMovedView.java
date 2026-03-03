package sofia.sap.interview.project.game.view;

import sofia.sap.interview.project.game.events.CharacterMovedEvent;

public class CharacterMovedView implements GameEventView<CharacterMovedEvent> {
    @Override
    public void render(CharacterMovedEvent event) {
        String formattedOutput =
            String.format("%s entered a new location called %s", event.characterName(), event.roomName());
        System.out.println(formattedOutput);
    }
}
