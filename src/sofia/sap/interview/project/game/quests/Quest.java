package sofia.sap.interview.project.game.quests;

import sofia.sap.interview.project.game.events.GameEvent;

public interface Quest {
    String questDescription();

    boolean isCompleted();

    void update(GameEvent event);
}
