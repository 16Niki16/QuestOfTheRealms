package sofia.sap.interview.project.game.inventory;

import sofia.sap.interview.project.game.inventory.items.Collectable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Chest {
    private final List<Collectable> content;

    private Chest(List<Collectable> content) {
        this.content = new ArrayList<>(content);
    }

    public static Chest createChestWithItems(List<Collectable> content) {
        return new Chest(content);
    }

    public static Chest createEmptyChest() {
        return new Chest(Collections.emptyList());
    }

    public List<Collectable> collectItems() {
        List<Collectable> items = List.copyOf(this.content);
        this.content.clear();
        return items;
    }
}
