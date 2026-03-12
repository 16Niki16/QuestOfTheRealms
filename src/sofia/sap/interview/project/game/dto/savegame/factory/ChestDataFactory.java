package sofia.sap.interview.project.game.dto.savegame.factory;

import sofia.sap.interview.project.game.dto.savegame.data.ChestData;
import sofia.sap.interview.project.game.items.Item;
import sofia.sap.interview.project.game.items.ItemType;
import sofia.sap.interview.project.game.map.room.Chest;

import java.util.Map;
import java.util.stream.Collectors;

public class ChestDataFactory {
    public static ChestData create(Chest chest) {
        ChestData data = new ChestData();

        Map<ItemType, Integer> items = chest.getContent()
                .stream()
                .collect(Collectors.groupingBy(
                        Item::getType,
                        Collectors.summingInt(i -> 1)
                ));

        data.setItems(items);

        return data;
    }
}
