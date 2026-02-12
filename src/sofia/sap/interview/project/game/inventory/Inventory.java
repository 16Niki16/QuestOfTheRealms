package sofia.sap.interview.project.game.inventory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class Inventory {
    private static final int LAST_ITEM = 1;
    private final Map<Item, Integer> items;

    public Inventory() {
        this.items = new HashMap<>();
    }

    public boolean checkItemInInventory(Item item) {
        return this.items.containsKey(item);
    }

    public void addItem(Item item) {
        this.items.put(item, this.items.getOrDefault(item, 0) + 1);
    }

    public void addAllItems(Collection<Item> items) {
        for (Item item : items) {
            addItem(item);
        }
    }

    public void removeItem(Item item) {
        int numberOfItems = this.items.get(item);

        if (numberOfItems > LAST_ITEM) {
            decrementItemNumber(item, numberOfItems);
        } else {
            removeItemTypeFromInventory(item);
        }
    }

    private void removeItemTypeFromInventory(Item item) {
        this.items.remove(item);
    }

    private void decrementItemNumber(Item type, int numberOfPotions) {
        this.items.put(type, --numberOfPotions);
    }
}
