package sofia.sap.interview.project.game.events;

import sofia.sap.interview.project.game.map.room.SpecialItem;

public record CollectSpecialItemEvent(SpecialItem item) implements GameEvent {
}
