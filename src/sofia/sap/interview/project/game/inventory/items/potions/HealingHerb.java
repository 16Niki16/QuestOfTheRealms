package sofia.sap.interview.project.game.inventory.items.potions;

import sofia.sap.interview.project.game.inventory.items.Item;

public class HealingHerb extends Item implements Potion {
    public HealingHerb(int effect) {
        super(effect);
    }

    @Override
    public int usePotion() {
        return getEffect();
    }
}
