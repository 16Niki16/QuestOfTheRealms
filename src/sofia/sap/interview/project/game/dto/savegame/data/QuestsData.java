package sofia.sap.interview.project.game.dto.savegame.data;

import java.util.List;
import java.util.Set;

public class QuestsData {
    private Set<QuestData> active;
    private Set<QuestData> completed;

    public Set<QuestData> getActive() {
        return active;
    }

    public void setActive(Set<QuestData> active) {
        this.active = active;
    }

    public Set<QuestData> getCompleted() {
        return completed;
    }

    public void setCompleted(Set<QuestData> completed) {
        this.completed = completed;
    }
}
