package sofia.sap.interview.project.game.inventory.items.gear;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.inventory.items.Collectable;

public interface Gear extends Collectable {
    void equipGear(Character character);

    void unequipGear(Character character);
}
