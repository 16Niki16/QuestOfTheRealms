package sofia.sap.interview.project.game.events;

import sofia.sap.interview.project.game.inventory.Item;

public class CollectItemEvent implements GameEvent {
    private final Item item;

    public CollectItemEvent(Item item) {
        this.item = item;
    }

    public Item getItemCollected() {
        return this.item;
    }
}
