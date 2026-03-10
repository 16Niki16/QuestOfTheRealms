package sofia.sap.interview.project.game.dto.savegame;

import java.util.Map;
import java.util.Set;

public class CharacterData {
    private String characterName;
    private String characterType;
    private int health;
    private int mana;
    private int minDamage;
    private int maxDamage;
    private Map<String, Integer> inventory;
    private Set<String> equipped;
}
