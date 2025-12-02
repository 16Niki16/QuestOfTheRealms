package sofia.sap.interview.project.game.characters.ally;

import sofia.sap.interview.project.game.characters.ally.type.Type;
import sofia.sap.interview.project.game.inventory.Collectable;

import java.util.HashMap;
import java.util.Map;

public class Character {
    private final String name;
    private Type type;
    private int health;
    private int mana;
    private final Map<Collectable, Integer> inventory;

    public Character(String name, Type type) {
        this.name = name;
        this.type = type;
        this.health = type.getHealth();
        this.mana = type.getMana();
        this.inventory = new HashMap<>();
    }

}
