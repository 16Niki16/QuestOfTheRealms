package sofia.sap.interview.project.game.map.dto.mappers;

import sofia.sap.interview.project.game.map.dto.RoomDTO;
import sofia.sap.interview.project.game.map.room.Room;

public class RoomMapper {
    public static Room map(RoomDTO content) {
        if (content == null) {
            return Room.emptyRoom();
        }

        return Room.roomCreator(EnemyMapper.map(content.enemies), ChestMapper.map(content.chest));
    }
}
