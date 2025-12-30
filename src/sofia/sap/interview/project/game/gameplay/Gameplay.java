package sofia.sap.interview.project.game.gameplay;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.map.Playground;

public class Gameplay {
    private Character character;
    private Playground playground;

    public Gameplay(Character character, Playground playground) {
        this.character = character;
        this.playground = playground;
    }
}
