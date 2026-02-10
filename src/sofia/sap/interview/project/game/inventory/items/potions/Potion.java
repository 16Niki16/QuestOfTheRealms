package sofia.sap.interview.project.game.inventory.items.potions;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.inventory.items.Collectable;

public interface Potion extends Collectable {
    void applyPotion(Character character);
}
