package sofia.sap.interview.project.game.events;

import sofia.sap.interview.project.game.map.room.SpecialItem;

public class CollectSpecialItemEvent implements GameEvent {
    private final SpecialItem item;

    public CollectSpecialItemEvent(SpecialItem item) {
        this.item = item;
    }

    public SpecialItem getItemCollected() {
        return this.item;
    }
}
