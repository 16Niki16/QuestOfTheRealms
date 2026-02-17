package sofia.sap.interview.project.game.quests;

import sofia.sap.interview.project.game.events.GameEvent;

public abstract class QuestBase implements Quest {
    private final String description;
    private boolean completed;

    public QuestBase(String description) {
        this.description = description;
        this.completed = false;
    }

    @Override
    public String questDescription() {
        return this.description;
    }

    @Override
    public boolean isCompleted() {
        return this.completed;
    }

    protected void completeQuest() {
        completed = true;
    }

    @Override
    public abstract void update(GameEvent event);
}
