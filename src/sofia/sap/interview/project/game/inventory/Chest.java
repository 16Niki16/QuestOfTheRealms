package sofia.sap.interview.project.game.inventory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Chest {
    private final List<Item> content;

    private Chest(List<Item> content) {
        this.content = new ArrayList<>(content);
    }

    public static Chest createChestWithItems(List<Item> content) {
        return new Chest(content);
    }

    public static Chest createEmptyChest() {
        return new Chest(Collections.emptyList());
    }

    public List<Item> collectItems() {
        List<Item> items = List.copyOf(this.content);
        this.content.clear();
        return items;
    }
}
