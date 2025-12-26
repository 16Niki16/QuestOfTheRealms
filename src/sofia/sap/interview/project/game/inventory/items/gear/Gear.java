package sofia.sap.interview.project.game.inventory.items.gear;

import sofia.sap.interview.project.game.characters.ally.Character;

public interface Gear {
    void equipGear(Character character);

    void unequipGear(Character character);
}
