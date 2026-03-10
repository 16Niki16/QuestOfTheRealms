package sofia.sap.interview.project.game.dto.savegame;

import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.items.Item;
import sofia.sap.interview.project.game.items.ItemType;
import sofia.sap.interview.project.game.map.Coordinates;
import sofia.sap.interview.project.game.quests.QuestLog;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GameDataFactory {
    public static GameData save(GameSession session, QuestLog log) {
        GameData game = new GameData();
        CharacterData character = game.getCharacter();

        character.setCharacterName(session.character().getCharacterName());
        character.setCharacterType(session.character().getCharacterType().name());
        character.setHealth(session.character().getCharacterStats().getHealth());
        character.setMana(session.character().getCharacterStats().getMana());
        character.setInventory(saveInventory(session.character().getInventory().getItems()));
        character.setEquipped(saveEquipped(session.character().getEquippedItems()));

        MapData map = game.getMap();
        Coordinates playerCoordinates = session.gameplay().getPlayerCoordinates();
        map.setCharacterX(playerCoordinates.x());
        map.setCharacterY(playerCoordinates.y());
    }

    private static Map<String, Integer> saveInventory(Map<ItemType, List<Item>> inventory) {
        return inventory.entrySet().stream()
            .collect(Collectors.toMap(
                e -> e.getKey().name(),
                e -> e.getValue().size()
            ));
    }

    private static Set<String> saveEquipped(Set<ItemType> equipped) {
        return equipped.stream()
            .map(ItemType::getName)
            .collect(Collectors.toSet());
    }
}
