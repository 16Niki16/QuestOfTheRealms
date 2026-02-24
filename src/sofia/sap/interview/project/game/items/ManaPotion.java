package sofia.sap.interview.project.game.items;

import sofia.sap.interview.project.game.characters.ally.Character;

public class ManaPotion implements Consumable {
    private static final int EFFECT = 10;

    @Override
    public void consume(Character character) {
        character.restoreMana(EFFECT);
    }
}
