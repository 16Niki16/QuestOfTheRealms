package sofia.sap.interview.project.game.dto.savegame.factory;

import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.dto.savegame.data.RoomData;
import sofia.sap.interview.project.game.map.room.Chest;
import sofia.sap.interview.project.game.map.room.Room;
import sofia.sap.interview.project.game.map.room.SpecialItem;

public class RoomDataFactory {
    public static RoomData create(Room room) {
        RoomData data = new RoomData();
        Chest chest = room.getChest();
        Enemy enemy = room.getEnemy();
        SpecialItem item = room.getSpecialItem();

        if (chest != null) {
            data.setChest(ChestDataFactory.create(chest));
        }
        if (enemy != null) {
            data.setEnemy(EnemyDataFactory.create(enemy));
        }
        if (item != null) {
            data.setSpecialItem(item);
        }
        return data;
    }
}
