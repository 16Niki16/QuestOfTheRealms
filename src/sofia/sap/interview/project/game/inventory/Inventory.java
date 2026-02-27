package sofia.sap.interview.project.game.inventory;

import sofia.sap.interview.project.game.exceptions.ItemNotAvailableException;
import sofia.sap.interview.project.game.items.Item;
import sofia.sap.interview.project.game.items.ItemFactory;
import sofia.sap.interview.project.game.items.ItemType;

import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

public class Inventory {
    private static final int LAST_ITEM = 1;
    private final Map<ItemType, Integer> items;

    public Inventory() {
        this.items = new EnumMap<>(ItemType.class);
    }

    public boolean checkItemInInventory(ItemType item) {
        return this.items.containsKey(item);
    }

    public void addItem(Item item) {
        this.items.put(item.getType(), this.items.getOrDefault(item, 0) + 1);
    }

    public void addAllItems(Collection<Item> items) {
        for (Item item : items) {
            addItem(item);
        }
    }

    public Item getItem(ItemType itemType) {

        if (!checkItemInInventory(itemType)) {
            throw new ItemNotAvailableException("The provided item is not in the inventory!");
        }

        return ItemFactory.create(itemType);
    }

    public void removeItem(Item item) {
        ItemType type = item.getType();
        int numberOfItems = this.items.get(item.getType());

        if (numberOfItems > LAST_ITEM) {
            decrementItemNumber(type, numberOfItems);
        } else {
            removeItemTypeFromInventory(type);
        }
    }

    private void removeItemTypeFromInventory(ItemType item) {
        this.items.remove(item);
    }

    private void decrementItemNumber(ItemType type, int numberOfPotions) {
        this.items.put(type, --numberOfPotions);
    }
}
