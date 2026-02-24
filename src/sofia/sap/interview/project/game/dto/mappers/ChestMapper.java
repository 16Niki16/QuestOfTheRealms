package sofia.sap.interview.project.game.dto.mappers;

import sofia.sap.interview.project.game.map.room.Chest;
import sofia.sap.interview.project.game.dto.ChestDTO;

import java.util.List;

public class ChestMapper {
    public static Chest map(ChestDTO dto) {
        if (dto == null || dto.items == null) {
            return null;
        }

        List<Item> items = dto.items.stream()
            .map(Item::getItem)
            .toList();

        return Chest.createChestWithItems(items);
    }
}
