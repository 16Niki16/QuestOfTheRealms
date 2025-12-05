package sofia.sap.interview.project.game.inventory.items;

import sofia.sap.interview.project.game.inventory.items.Collectable;

public class Item implements Collectable {
    private final int effect;

    public Item(int effect) {
        this.effect = effect;
    }

    @Override
    public int getEffect() {
        return this.effect;
    }
}
