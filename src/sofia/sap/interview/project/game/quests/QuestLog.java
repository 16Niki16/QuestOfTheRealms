package sofia.sap.interview.project.game.quests;

import sofia.sap.interview.project.game.events.GameEvent;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class QuestLog {
    private final Map<Quest, Reward> activeQuests;
    private final Set<Quest> completedQuests;
    private int collectedXP;

    public QuestLog(Map<Quest, Reward> activeQuests) {
        this.activeQuests = activeQuests;
        this.completedQuests = new HashSet<>();
        this.collectedXP = 0;
    }

    public Set<Quest> getActiveQuests() {
        return activeQuests.keySet();
    }

    public Set<Quest> getCompletedQuests() {
        return completedQuests;
    }

    public void handleEvent(GameEvent event) {
        for (Map.Entry<Quest, Reward> quest : activeQuests.entrySet()) {
            Quest currQuest = quest.getKey();
            currQuest.update(event);

            if (currQuest.isCompleted()) {
                this.activeQuests.remove(currQuest);
                this.completedQuests.add(currQuest);
                this.collectedXP += quest.getValue().getRewardXP();
            }
        }
    }

    public int getCollectedXP() {
        return this.collectedXP;
    }
}
