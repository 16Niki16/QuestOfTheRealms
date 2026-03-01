package sofia.sap.interview.project.game.quests;

import sofia.sap.interview.project.game.events.GameEvent;

import java.util.HashSet;
import java.util.Iterator;
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
        Iterator<Map.Entry<Quest, Reward>> it = activeQuests.entrySet().iterator();
        while (it.hasNext()) {
            var entry = it.next();
            Quest quest = entry.getKey();

            quest.update(event);
            if (quest.isCompleted()) {
                it.remove();
                completedQuests.add(quest);
                collectedXP += entry.getValue().getRewardXP();
            }
        }
    }

    public int getCollectedXP() {
        return this.collectedXP;
    }

    public String questsStatus() {
        return QuestLogStatus.parser(this.completedQuests, this.activeQuests.keySet());
    }
}
