package sofia.sap.interview.project.game.inventory.items.gear;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.inventory.items.Item;
import sofia.sap.interview.project.game.inventory.items.type.ItemType;

public class IronDagger extends Item implements Gear {

    public IronDagger() {
        super(ItemType.IRON_DAGGER);
    }

    @Override
    public void equipGear(Character character) {
        character.increaseAttackDamage(getEffect());
    }

    @Override
    public void unequipGear(Character character) {
        character;
    }
}
