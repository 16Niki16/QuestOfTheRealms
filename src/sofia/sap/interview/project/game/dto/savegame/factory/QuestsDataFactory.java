package sofia.sap.interview.project.game.dto.savegame.factory;

import sofia.sap.interview.project.game.dto.savegame.data.QuestData;
import sofia.sap.interview.project.game.dto.savegame.data.QuestsData;
import sofia.sap.interview.project.game.quests.Quest;
import sofia.sap.interview.project.game.quests.QuestLog;

import java.util.Set;
import java.util.stream.Collectors;

public class QuestsDataFactory {
    public static QuestsData create(QuestLog log) {
        QuestsData questsData = new QuestsData();

        questsData.setActive(createQuest(log.getActiveQuests()));
        questsData.setCompleted(createQuest(log.getCompletedQuests()));
        questsData.setCollectedXP(log.getCollectedXP());

        return questsData;
    }

    private static Set<QuestData> createQuest(Set<Quest> quests) {
        return quests.stream()
                .map(Quest::toSave)
                .collect(Collectors.toSet());
    }
}
