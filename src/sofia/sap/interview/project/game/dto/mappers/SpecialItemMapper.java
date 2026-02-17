package sofia.sap.interview.project.game.dto.mappers;

import sofia.sap.interview.project.game.map.room.items.SpecialItem;

public class SpecialItemMapper {
    public static SpecialItem map(String specialItem) {
        return specialItem == null ? null : SpecialItem.valueOf(specialItem);
    }
}
