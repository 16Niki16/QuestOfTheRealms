package sofia.sap.interview.project.game.inventory;

import sofia.sap.interview.project.game.exceptions.ItemNotAvailableException;
import sofia.sap.interview.project.game.items.Item;
import sofia.sap.interview.project.game.items.ItemFactory;
import sofia.sap.interview.project.game.items.ItemType;

import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private static final int LAST_ITEM = 1;
    private final Map<ItemType, Integer> items;

    public Inventory() {
        this.items = new EnumMap<>(ItemType.class);
    }

    public boolean checkItemInInventory(Item item) {
        return this.items.containsKey(item.getType());
    }

    public void addItem(Item item) {
        this.items.put(item.getType(), this.items.getOrDefault(item.getType(), 0) + 1);
    }

    public void addAllItems(Collection<Item> items) {
        for (Item item : items) {
            addItem(item);
        }
    }

    public Item getItem(String itemName) {
        ItemType itemType = ItemType.getByName(itemName);
        Item item = ItemFactory.create(itemType);

        if (!checkItemInInventory(item)) {
            throw new ItemNotAvailableException("The provided item is not in the inventory!");
        }
        return item;
    }

    public void removeItem(Item item) {
        int numberOfItems = this.items.get(item.getType());

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
