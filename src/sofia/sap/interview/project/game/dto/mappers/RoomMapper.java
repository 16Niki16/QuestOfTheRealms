package sofia.sap.interview.project.game.dto.mappers;

import sofia.sap.interview.project.game.dto.RoomDTO;
import sofia.sap.interview.project.game.map.room.Room;

public class RoomMapper {
    public static Room map(RoomDTO content) {
        if (content == null) {
            return Room.emptyRoom();
        }

        return new Room(EnemyMapper.map(content.enemy), ChestMapper.map(content.chest),
                SpecialItemMapper.map(content.specialItem));
    }
}
