package sofia.sap.interview.project.game.events;

import sofia.sap.interview.project.game.dto.events.InteractionDTO;

public record DefendEvent(InteractionDTO dto) implements GameEvent {
}
