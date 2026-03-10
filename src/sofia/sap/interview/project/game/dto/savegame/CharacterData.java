package sofia.sap.interview.project.game.dto.savegame;

import java.util.Map;
import java.util.Set;

public class CharacterData {
    private String characterName;
    private String characterType;
    private int health;
    private int mana;
    private Map<String, Integer> inventory;
    private Set<String> equipped;

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getCharacterType() {
        return characterType;
    }

    public void setCharacterType(String characterType) {
        this.characterType = characterType;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }

    public void setInventory(Map<String, Integer> inventory) {
        this.inventory = inventory;
    }

    public Set<String> getEquipped() {
        return equipped;
    }

    public void setEquipped(Set<String> equipped) {
        this.equipped = equipped;
    }
}
