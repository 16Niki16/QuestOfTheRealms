package sofia.sap.interview.project.game.dto.loadgame;

import sofia.sap.interview.project.game.dto.savegame.data.QuestData;
import sofia.sap.interview.project.game.dto.savegame.data.QuestsData;
import sofia.sap.interview.project.game.quests.Quest;
import sofia.sap.interview.project.game.quests.QuestLog;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class QuestLogFactory {
    public static QuestLog create(QuestsData data) {
        Set<QuestData> active = data.getActive();
        Set<QuestData> completed = data.getCompleted();

        Set<Quest> activeQuests = transform(active);
        Set<Quest> completedQuests = transform(completed);

        return QuestLog.load(activeQuests, completedQuests, data.getCollectedXP());
    }

    private static Set<Quest> transform(Set<QuestData> quests) {
        return quests.stream()
                .map(QuestFactory::create)
                .collect(Collectors.toCollection(HashSet::new));
    }
}
