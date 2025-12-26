package sofia.sap.interview.project.game.inventory.items.potions;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.inventory.items.Item;
import sofia.sap.interview.project.game.inventory.items.type.ItemType;

public class HealingHerb extends Item implements Potion {
    public HealingHerb() {
        super(ItemType.HEALING_HERB);
    }

    @Override
    public void applyPotion(Character character) {
        character.heal(getEffect());
    }
}
