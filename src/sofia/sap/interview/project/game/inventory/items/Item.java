package sofia.sap.interview.project.game.inventory.items;

import sofia.sap.interview.project.game.inventory.items.type.ItemType;

public class Item implements Collectable {
    private final ItemType type;

    public Item(ItemType type) {
        this.type = type;
    }

    @Override
    public int getEffect() {
        return this.type.getEffect();
    }

    @Override
    public ItemType getType() {
        return this.type;
    }
}
