package sofia.sap.interview.project.game.dto.events;

import sofia.sap.interview.project.game.quests.Quest;
import sofia.sap.interview.project.game.quests.QuestType;

public record QuestCompletedDTO(QuestType type, String description) {
    public static QuestCompletedDTO from(Quest quest) {
        return new QuestCompletedDTO(quest.getType(), quest.questDescription());
    }
}
