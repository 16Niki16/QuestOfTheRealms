package sofia.sap.interview.project.game.characters.ally;

import sofia.sap.interview.project.game.characters.ally.type.Type;
import sofia.sap.interview.project.game.inventory.items.Collectable;

import java.util.HashMap;
import java.util.Map;

public class Character {
    private final String name;
    private final Type type;
    private final CharacterStatistics characterStats;
    private final Map<Collectable, Integer> inventory;

    public Character(String name, Type type) {
        this.name = name;
        this.type = type;
        this.characterStats = new CharacterStatistics(type);
        this.inventory = new HashMap<>();
    }

}
