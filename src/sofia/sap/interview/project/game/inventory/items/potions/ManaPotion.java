package sofia.sap.interview.project.game.inventory.items.potions;

import sofia.sap.interview.project.game.inventory.items.Item;

public class ManaPotion extends Item implements Potion {

    public ManaPotion(int effect) {
        super(effect);
    }

    @Override
    public int usePotion() {
        return getEffect();
    }
}
