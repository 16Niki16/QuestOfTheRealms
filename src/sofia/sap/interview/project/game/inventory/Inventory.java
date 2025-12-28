package sofia.sap.interview.project.game.inventory;

import sofia.sap.interview.project.game.exceptions.ItemNotAvailableException;
import sofia.sap.interview.project.game.inventory.items.Collectable;
import sofia.sap.interview.project.game.inventory.items.Item;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private static final int LAST_ITEM = 1;
    private final Map<Collectable, Integer> items;

    public Inventory() {
        this.items = new HashMap<>();
    }

    public boolean checkItemInInventory(Collectable item) {
        return this.items.containsKey(item);
    }

    public void addItem(Collectable item) {
        this.items.put(item, this.items.getOrDefault(item, 0) + 1);
    }

    public Collectable getItem(Collectable item) {
        if (!items.containsKey(item)) {
            throw new ItemNotAvailableException("The item type you want to use is not available!");
        }

        int numberOfItemsByType = items.get(item);
        if (numberOfItemsByType == LAST_ITEM) {
            removeItemTypeFromInventory(item);
        } else {
            decrementItemNumber(item, numberOfItemsByType);
        }
        return item;
    }

    private void removeItemTypeFromInventory(Collectable item) {
        this.items.remove(item);
    }

    private void decrementItemNumber(Collectable type, int numberOfPotions) {
        this.items.put(type, --numberOfPotions);
    }
}
