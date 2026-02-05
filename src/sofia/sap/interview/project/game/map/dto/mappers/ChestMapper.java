package sofia.sap.interview.project.game.map.dto.mappers;

import sofia.sap.interview.project.game.inventory.Chest;
import sofia.sap.interview.project.game.inventory.items.Collectable;
import sofia.sap.interview.project.game.map.dto.ChestDTO;

import java.util.List;

public class ChestMapper {
    public static Chest map(ChestDTO dto) {
        if (dto == null || dto.items == null) {
            return Chest.createEmptyChest();
        }

        List<Collectable> items = dto.items.stream()
            .map(Collectable::createItem)
            .toList();

        return Chest.createChestWithItems(items);
    }
}
