package sofia.sap.interview.project.game.events;

import sofia.sap.interview.project.game.map.room.items.SpecialItem;

public class CollectItemEvent implements GameEvent {
    private final SpecialItem item;

    public CollectItemEvent(SpecialItem item) {
        this.item = item;
    }

    public SpecialItem getItemCollected() {
        return this.item;
    }
}
