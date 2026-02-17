package sofia.sap.interview.project.game.quests;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class QuestLog {
    private final Map<Quest, Reward> activeQuests;
    private final Map<Quest, Reward> completedQuests;

    public QuestLog(Map<Quest, Reward> activeQuests) {
        this.activeQuests = activeQuests;
        this.completedQuests = new HashMap<>();
    }

    public Set<Quest> getActiveQuests() {
        return activeQuests.keySet();
    }

    public Set<Quest> getCompletedQuests() {
        return completedQuests.keySet();
    }
}
