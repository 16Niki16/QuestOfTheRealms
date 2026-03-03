package sofia.sap.interview.project.game.view;

import sofia.sap.interview.project.game.events.GameEvent;

public interface GameEventView<E extends GameEvent> {
    void render(E event);
}
