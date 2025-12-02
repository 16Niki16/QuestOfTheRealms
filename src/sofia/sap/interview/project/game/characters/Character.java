package sofia.sap.interview.project.game.characters;

import sofia.sap.interview.project.game.inventory.Item;

import java.util.HashMap;
import java.util.Map;

public class Character {
    private final String name;
    private final Type type;
    private final Map<Item, Integer> inventory;

    public Character(String name, Type type) {
        this.name = name;
        this.type = type;
        this.inventory = new HashMap<>();
    }

    public
}
