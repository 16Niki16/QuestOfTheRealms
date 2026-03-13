package sofia.sap.interview.project.game.dto.loadgame;

import sofia.sap.interview.project.game.dto.savegame.data.QuestData;
import sofia.sap.interview.project.game.dto.savegame.data.QuestsData;
import sofia.sap.interview.project.game.quests.Quest;
import sofia.sap.interview.project.game.quests.QuestList;
import sofia.sap.interview.project.game.quests.QuestLog;

import java.util.Set;
import java.util.stream.Collectors;

public class QuestLogFactory {
    public static QuestLog create(QuestsData data) {
        Set<QuestData> active = data.getActive();
        Set<QuestData> completed = data.getCompleted();
        int collectedXP = data.getCollectedXP();

        Set<Quest> activeQuests = active.stream()
                .map(QuestData::getType)
                .map(QuestList::getQuest)
                .collect(Collectors.toSet());

        Set<Quest> completedQuests = completed.stream()
                .map(QuestData::getType)
                .map(QuestList::getQuest)
                .collect(Collectors.toSet());
    }
}
