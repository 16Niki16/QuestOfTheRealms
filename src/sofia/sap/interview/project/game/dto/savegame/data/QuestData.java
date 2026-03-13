package sofia.sap.interview.project.game.dto.savegame.data;

import sofia.sap.interview.project.game.quests.QuestType;

public class QuestData {
    private QuestType type;
    private boolean completed;
    private int progress;

    public QuestType getType() {
        return type;
    }

    public void setType(QuestType type) {
        this.type = type;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
