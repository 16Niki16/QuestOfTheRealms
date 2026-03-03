package sofia.sap.interview.project.game.events;

import sofia.sap.interview.project.game.items.Item;
import sofia.sap.interview.project.game.items.ItemType;

public record ItemUnequipEvent(ItemType type, int effect) implements GameEvent {
    public static ItemEquipEvent equipEvent(Item item) {
        return new ItemEquipEvent(item.getType(), item.getEffect());
    }
}
