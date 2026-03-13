package sofia.sap.interview.project.game.dto.savegame.factory;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.dto.savegame.data.CharacterData;
import sofia.sap.interview.project.game.items.Item;
import sofia.sap.interview.project.game.items.ItemType;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CharacterDataFactory {
    public static CharacterData create(Character character) {
        CharacterData characterData = new CharacterData();

        characterData.setCharacterName(character.getCharacterName());
        characterData.setCharacterType(character.getCharacterType());
        characterData.setCharacterStatisticsData(CharacterStatisticsDataFactory.create(character.getCharacterStats()));
        characterData.setInventory(saveInventory(character.getInventory().getItems()));
        characterData.setEquipped(character.getEquippedItems());

        return characterData;
    }

    private static Map<ItemType, Integer> saveInventory(Map<ItemType, List<Item>> inventory) {
        return inventory.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().size()
                ));
    }

}
