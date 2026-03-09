package sofia.sap.interview.project.game.quests;

import sofia.sap.interview.project.game.events.GameEvent;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class QuestLog {
    private final Set<Quest> activeQuests;
    private final Set<Quest> completedQuests;
    private int collectedXP;

    public QuestLog() {
        this.activeQuests = QuestList.createQuests();
        this.completedQuests = new HashSet<>();
        this.collectedXP = 0;
    }

    public Set<Quest> getActiveQuests() {
        return Collections.unmodifiableSet(activeQuests);
    }

    public Set<Quest> getCompletedQuests() {
        return Collections.unmodifiableSet(completedQuests);
    }

    public boolean handleEvent(GameEvent event) {
        Iterator<Quest> it = activeQuests.iterator();
        while (it.hasNext()) {
            Quest quest = it.next();
            quest.update(event);

            if (quest.isCompleted()) {
                it.remove();
                completedQuests.add(quest);
                collectedXP += quest.getReward().getRewardXP();
                return true;
            }
        }
        return false;
    }

    public int getCollectedXP() {
        return this.collectedXP;
    }
}
