package sofia.sap.interview.project.game.inventory.items;

import sofia.sap.interview.project.game.inventory.items.type.ItemType;

public interface Collectable {
    int getEffect();

    ItemType getType();
}
