package sofia.sap.interview.project.game.inventory;

import sofia.sap.interview.project.game.inventory.items.Collectable;

import java.util.ArrayList;
import java.util.List;

public class Chest {
    private final List<Collectable> content;

    public Chest() {
        this.content = new ArrayList<>();
    }

    public Chest(List<Collectable> content) {
        this.content = new ArrayList<>(content);
    }

    public List<Collectable> collectItems() {
        return this.content;
    }
}
