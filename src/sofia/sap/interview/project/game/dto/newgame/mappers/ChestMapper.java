package sofia.sap.interview.project.game.dto.newgame.mappers;

import sofia.sap.interview.project.game.dto.newgame.ChestDTO;
import sofia.sap.interview.project.game.items.Item;
import sofia.sap.interview.project.game.items.ItemFactory;
import sofia.sap.interview.project.game.items.ItemType;
import sofia.sap.interview.project.game.map.room.Chest;

import java.util.List;

public class ChestMapper {
    public static Chest map(ChestDTO dto) {
        if (dto == null || dto.items == null) {
            return null;
        }

        List<Item> items = dto.items.stream()
                .map(ItemType::getByName)
                .map(ItemFactory::create)
                .toList();

        return Chest.createChest(items);
    }
}
