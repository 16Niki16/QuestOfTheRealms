package sofia.sap.interview.project.game.dto.savegame;

import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.items.Item;
import sofia.sap.interview.project.game.items.ItemType;
import sofia.sap.interview.project.game.map.Coordinates;
import sofia.sap.interview.project.game.map.room.Chest;
import sofia.sap.interview.project.game.map.room.Room;
import sofia.sap.interview.project.game.map.room.SpecialItem;
import sofia.sap.interview.project.game.quests.Quest;
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
        map.setRooms(saveRooms(session.gameplay().getPlayground().getRooms()));

        QuestsData quests = game.getQuests();
        quests.setActive();
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

    private static RoomData[][] saveRooms(Room[][] rooms) {
        RoomData[][] result = new RoomData[rooms.length][rooms[0].length];

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                result[i][j] = saveRoom(rooms[i][j]);
            }
        }

        return result;
    }

    private static RoomData saveRoom(Room room) {
        RoomData data = new RoomData();
        Chest chest = room.getChest();
        Enemy enemy = room.getEnemy();
        SpecialItem item = room.getSpecialItem();

        if (chest != null) {
            ChestData chestData = new;
            chestData.setItems(fromChest(chest));
        }
        if (enemy != null) {
            EnemyData enemyData = data.getEnemy();
            enemyData.setEnemy(enemy.getType().getName());
            enemyData.setHealth(enemy.health());
        }
        if (item != null) {
            data.setSpecialItem(room.getSpecialItem().getName());
        }
        return data;
    }

    private static List<String> fromChest(Chest chest) {
        return chest.getContent().stream()
                .map(e -> e.getType().getName())
                .collect(Collectors.toList());
    }

    private static List<String> quests(Set<Quest> quests) {

    }
}
