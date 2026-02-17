package sofia.sap.interview.project.game.quests;

import sofia.sap.interview.project.game.events.GameEvent;

public abstract class QuestBase implements Quest {
    private boolean completed;

    public QuestBase() {
        this.completed = false;
    }

    @Override
    public abstract String questDescription();

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
