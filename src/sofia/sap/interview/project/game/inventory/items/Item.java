package sofia.sap.interview.project.game.inventory.items;

import sofia.sap.interview.project.game.inventory.items.type.Type;

public class Item implements Collectable {
    private final Type type;

    public Item(Type type) {
        this.type = type;
    }

    @Override
    public int getEffect() {
        return this.type.getEffect();
    }

    @Override
    public Type getType() {
        return this.type;
    }
}
