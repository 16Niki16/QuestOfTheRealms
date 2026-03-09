package sofia.sap.interview.project.game.events;

import sofia.sap.interview.project.game.dto.events.InteractionDTO;

public record AttackEvent(InteractionDTO interaction) implements GameEvent {
}
