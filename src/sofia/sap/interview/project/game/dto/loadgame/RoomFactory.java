package sofia.sap.interview.project.game.dto.loadgame;

import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.dto.savegame.data.RoomData;
import sofia.sap.interview.project.game.map.room.Chest;
import sofia.sap.interview.project.game.map.room.Room;

public class RoomFactory {
    public static Room create(RoomData data) {
        Enemy enemy = null;
        Chest chest = null;

        if (data.getEnemy() != null) {
            enemy = EnemyFactory.create(data.getEnemy());
        }
        if (data.getChest() != null) {
            chest = ChestFactory.create(data.getChest());
        }
        return new Room(data.getName(), enemy, chest, data.getSpecialItem());
    }
}
