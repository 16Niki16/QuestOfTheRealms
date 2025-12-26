package sofia.sap.interview.project.game.inventory;

import sofia.sap.interview.project.game.exceptions.ItemNotAvailableException;
import sofia.sap.interview.project.game.inventory.items.Item;
import sofia.sap.interview.project.game.inventory.items.type.ItemType;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private static final int LAST_ITEM = 1;
    private final Map<Item, Integer> items;

    public Inventory() {
        this.items = new HashMap<>();
    }

    public void addItem(Item item) {
        this.items.put(item, this.items.getOrDefault(item, 0) + 1);
    }

    public void addItem(Item item) {
        this.items.put(item, this.items.getOrDefault(item, 0) + 1);
    }

    public ItemType getItem(Item item) {
        if (!items.containsKey(item)) {
            throw new ItemNotAvailableException("The item type you want to use is not available!");
        }

        int numberOfItemsByType = items.get(item);
        if (numberOfItemsByType == LAST_ITEM) {
            removeItemTypeFromInventory(type);
        } else {
            decrementItemNumber(type, numberOfItemsByType);
        }
        return type;
    }

    private void removeItemTypeFromInventory(ItemType type) {
        this.items.remove(type);
    }

    private void decrementItemNumber(ItemType type, int numberOfPotions) {
        this.items.put(type, --numberOfPotions);
    }
}
