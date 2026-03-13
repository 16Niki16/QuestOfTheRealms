package sofia.sap.interview.project.game.dto.savegame.data;

import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.items.ItemType;

import java.util.Map;
import java.util.Set;

public class CharacterData {
    private String characterName;
    private AllyCharacterType characterType;
    private CharacterStatisticsData characterStatisticsData;

    public CharacterStatisticsData getCharacterStatisticsData() {
        return characterStatisticsData;
    }

    public void setCharacterStatisticsData(CharacterStatisticsData characterStatisticsData) {
        this.characterStatisticsData = characterStatisticsData;
    }

    private Map<ItemType, Integer> inventory;
    private Set<ItemType> equipped;

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public AllyCharacterType getCharacterType() {
        return characterType;
    }

    public void setCharacterType(AllyCharacterType characterType) {
        this.characterType = characterType;
    }

    public Map<ItemType, Integer> getInventory() {
        return inventory;
    }

    public void setInventory(Map<ItemType, Integer> inventory) {
        this.inventory = inventory;
    }

    public Set<ItemType> getEquipped() {
        return equipped;
    }

    public void setEquipped(Set<ItemType> equipped) {
        this.equipped = equipped;
    }
}
