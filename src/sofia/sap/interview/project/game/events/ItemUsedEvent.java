package sofia.sap.interview.project.game.events;

import sofia.sap.interview.project.game.items.Item;
import sofia.sap.interview.project.game.items.ItemType;

public record ItemUsedEvent(ItemType type, int effect) implements GameEvent {
    public static ItemUsedEvent potionEffect(Item item) {
        return new ItemUsedEvent(item.getType(), item.getEffect());
    }
}
