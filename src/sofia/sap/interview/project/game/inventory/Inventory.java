package sofia.sap.interview.project.game.inventory;

import sofia.sap.interview.project.game.inventory.items.Collectable;

import java.util.Collection;
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

    public void addAllItems(Collection<Collectable> items) {
        for (Collectable item : items) {
            addItem(item);
        }
    }

    public void removeItem(Collectable item) {
        int numberOfItems = this.items.get(item);

        if (numberOfItems > LAST_ITEM) {
            decrementItemNumber(item, numberOfItems);
        } else {
            removeItemTypeFromInventory(item);
        }
    }

    private void removeItemTypeFromInventory(Collectable item) {
        this.items.remove(item);
    }

    private void decrementItemNumber(Collectable type, int numberOfPotions) {
        this.items.put(type, --numberOfPotions);
    }
}
