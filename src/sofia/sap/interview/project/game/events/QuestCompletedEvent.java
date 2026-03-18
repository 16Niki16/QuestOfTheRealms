package sofia.sap.interview.project.game.events;

import sofia.sap.interview.project.game.dto.events.QuestCompletedDTO;

public record QuestCompletedEvent(QuestCompletedDTO dto) implements GameEvent {
}
