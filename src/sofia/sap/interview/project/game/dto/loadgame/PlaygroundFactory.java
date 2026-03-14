package sofia.sap.interview.project.game.dto.loadgame;

import sofia.sap.interview.project.game.dto.savegame.data.PlaygroundData;
import sofia.sap.interview.project.game.map.Playground;
import sofia.sap.interview.project.game.map.room.Room;

public class PlaygroundFactory {
    public static Playground create(PlaygroundData data) {
        Room[][] result = new Room[data.getRoom().length][data.getRoom()[0].length];

        for (int i = 0; i < data.getRoom().length; i++) {
            for (int j = 0; j < data.getRoom()[i].length; j++) {
                result[i][j] = RoomFactory.create(data.getRoom()[i][j]);
            }
        }

        return new Playground(result);
    }
}
