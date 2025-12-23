package sofia.sap.interview.project.game.inventory;

import sofia.sap.interview.project.game.exceptions.PotionNotAvailableException;
import sofia.sap.interview.project.game.inventory.items.Collectable;
import sofia.sap.interview.project.game.inventory.items.type.ItemType;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private static final int LAST_POTION = 1;
    private final Map<ItemType, Integer> items;

    public Inventory() {
        this.items = new HashMap<>();
    }

    public void addItem(ItemType item) {
        this.items.put(item, this.items.getOrDefault(item, 0) + 1);
    }

    public void addItem(Collectable item) {
        this.items.put(item.getType(), this.items.getOrDefault(item.getType(), 0) + 1);
    }

    public Map<ItemType, Integer> getInventoryContent() {
        return this.items;
    }

    public ItemType getItem(ItemType type) {
        if (!items.containsKey(type)) {
            throw new PotionNotAvailableException("The potion type you want to use is not available!");
        }

        int numberOfPotions = items.get(type);
        if (numberOfPotions == LAST_POTION) {
            removePotionTypeFromInventory(type);
        } else {
            decrementPotionNumber(type, numberOfPotions);
        }
        return type;
    }

    private void removePotionTypeFromInventory(ItemType type) {
        this.items.remove(type);
    }

    private void decrementPotionNumber(ItemType type, int numberOfPotions) {
        this.items.put(type, --numberOfPotions);
    }
}
