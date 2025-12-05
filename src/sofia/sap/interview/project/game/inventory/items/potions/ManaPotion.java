package sofia.sap.interview.project.game.inventory.items.potions;

import sofia.sap.interview.project.game.inventory.items.Item;
import sofia.sap.interview.project.game.inventory.items.type.Type;

public class ManaPotion extends Item implements Potion {

    public ManaPotion() {
        super(Type.MANA_POTION);
    }

    @Override
    public int usePotion() {
        return getEffect();
    }
}
