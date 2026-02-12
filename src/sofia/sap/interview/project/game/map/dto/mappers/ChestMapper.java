package sofia.sap.interview.project.game.map.dto.mappers;

import sofia.sap.interview.project.game.inventory.Chest;
import sofia.sap.interview.project.game.inventory.Item;
import sofia.sap.interview.project.game.map.dto.ChestDTO;

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
