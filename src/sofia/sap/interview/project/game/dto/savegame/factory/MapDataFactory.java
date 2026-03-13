package sofia.sap.interview.project.game.dto.savegame.factory;

import sofia.sap.interview.project.game.dto.savegame.data.MapData;
import sofia.sap.interview.project.game.dto.savegame.data.RoomData;
import sofia.sap.interview.project.game.gameplay.Gameplay;
import sofia.sap.interview.project.game.map.room.Room;

public class MapDataFactory {
    public static MapData create(Gameplay gameplay) {
        MapData map = new MapData();

        map.setRooms(saveRooms(gameplay.getPlayground().getRooms()));
        map.setCoordinates(gameplay.getPlayerCoordinates());

        return map;
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
}
