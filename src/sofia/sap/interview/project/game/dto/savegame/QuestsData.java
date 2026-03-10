package sofia.sap.interview.project.game.dto.savegame;

import java.util.List;

public class QuestsData {
    private List<String> active;
    private List<String> completed;

    public List<String> getActive() {
        return active;
    }

    public void setActive(List<String> active) {
        this.active = active;
    }

    public List<String> getCompleted() {
        return completed;
    }

    public void setCompleted(List<String> completed) {
        this.completed = completed;
    }
}
