package sofia.sap.interview.project.game.inventory.items.potions;

import sofia.sap.interview.project.game.inventory.items.Item;
import sofia.sap.interview.project.game.inventory.items.type.Type;

public class HealingHerb extends Item implements Potion {
    public HealingHerb() {
        super(Type.HEALING_HERB);
    }

    @Override
    public int usePotion() {
        return getEffect();
    }
}
