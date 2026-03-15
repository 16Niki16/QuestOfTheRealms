package sofia.sap.interview.project.game.dto.savegame.data;

import java.util.Set;

public record QuestsData(Set<QuestData> active, Set<QuestData> completed, int collectedXP) {
}
