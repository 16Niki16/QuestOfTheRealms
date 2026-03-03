package sofia.sap.interview.project.game.events;

import sofia.sap.interview.project.game.items.Item;
import sofia.sap.interview.project.game.items.ItemType;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public record CollectItemsEvent(Map<ItemType, Long> items) implements GameEvent {
    public static CollectItemsEvent collectEvent(Collection<Item> items) {

        Map<ItemType, Long> grouped = items.stream()
            .collect(Collectors.groupingBy(
                Item::getType,
                Collectors.counting()
            ));

        return new CollectItemsEvent(grouped);
    }
}
