package sofia.sap.interview.project.game.dto.savegame.factory;

import sofia.sap.interview.project.game.dto.savegame.data.CharacterData;
import sofia.sap.interview.project.game.dto.savegame.data.GameData;
import sofia.sap.interview.project.game.dto.savegame.data.MapData;
import sofia.sap.interview.project.game.dto.savegame.data.QuestsData;
import sofia.sap.interview.project.game.dto.savegame.data.RoomData;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.items.Item;
import sofia.sap.interview.project.game.items.ItemType;
import sofia.sap.interview.project.game.map.Coordinates;
import sofia.sap.interview.project.game.map.room.Room;
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
        character.setCharacterType(session.character().getCharacterType());
        character.setHealth(session.character().getCharacterStats().getHealth());
        character.setMana(session.character().getCharacterStats().getMana());
        character.setInventory(saveInventory(session.character().getInventory().getItems()));
        character.setEquipped(session.character().getEquippedItems());

        MapData map = game.getMap();
        Coordinates playerCoordinates = session.gameplay().getPlayerCoordinates();
        map.setCharacterX(playerCoordinates.x());
        map.setCharacterY(playerCoordinates.y());
        map.setRooms(saveRooms(session.gameplay().getPlayground().getRooms()));

        QuestsData quests = game.getQuests();
        quests.setActive();
    }

    private static Map<ItemType, Integer> saveInventory(Map<ItemType, List<Item>> inventory) {
        return inventory.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().size()
                ));
    }

    private static RoomData[][] saveRooms(Room[][] rooms) {
        RoomData[][] result = new RoomData[rooms.length][rooms[0].length];

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                result[i][j] = RoomDataFactory.create(rooms[i][j]);
            }
        }

        return result;
    }

    private static List<String> quests(Set<Quest> quests) {
        return quests.stream()
                .map()
    }
}
