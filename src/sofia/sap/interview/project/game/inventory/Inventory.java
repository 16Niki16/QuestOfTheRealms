package sofia.sap.interview.project.game.inventory;

import sofia.sap.interview.project.game.exceptions.HealingPotionNotAvailableException;
import sofia.sap.interview.project.game.inventory.items.Collectable;
import sofia.sap.interview.project.game.inventory.items.type.ItemType;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private static final int LAST_POTION = 1;
    private Map<ItemType, Integer> items;

    public Inventory() {
        this.items = new HashMap<>();
    }

    public Collectable addItem(Collectable item) {
        this.items.put(item.getType(), this.items.getOrDefault(item.getType(), 0) + 1);
        return item;
    }

    public Map<ItemType, Integer> getInventoryContent() {
        return this.items;
    }

    public ItemType getHealingPotion() {
        if (!items.containsKey(ItemType.HEALING_HERB)) {
            throw new HealingPotionNotAvailableException("There is not a healing potion in your inventory");
        }

        int numberOfPotions = items.get(ItemType.HEALING_HERB);
        if (numberOfPotions == LAST_POTION) {
            removePotionTypeFromInventory(ItemType.HEALING_HERB);
        } else {
            decrementPotionNumber(ItemType.HEALING_HERB, numberOfPotions);
        }

        return ItemType.HEALING_HERB;
    }

    private void removePotionTypeFromInventory(ItemType type) {
        this.items.remove(type);
    }

    private void decrementPotionNumber(ItemType type, int numberOfPotions) {
        this.items.put(type, --numberOfPotions);
    }
}
