package sofia.sap.interview.project.game.inventory;

import sofia.sap.interview.project.game.inventory.items.Collectable;
import sofia.sap.interview.project.game.inventory.items.type.Type;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    private Map<Type, Integer> items;

    public Inventory() {
        this.items = new HashMap<>();
    }

    public Collectable addItem(Collectable item) {
        this.items.put(item.getType(), this.items.getOrDefault(item.getType(), 0) + 1);
        return item;
    }

    public Map<Type, Integer> getInventoryContent() {
        return this.items;
    }
}
