package sofia.sap.interview.project.game.inventory.items;

import sofia.sap.interview.project.game.inventory.items.type.Type;

public interface Collectable {
    int getEffect();

    Type getType();
}
