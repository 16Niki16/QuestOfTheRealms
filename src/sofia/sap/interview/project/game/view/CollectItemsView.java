package sofia.sap.interview.project.game.view;

import sofia.sap.interview.project.game.events.CollectItemsEvent;
import sofia.sap.interview.project.game.items.ItemType;

import java.util.Map;

public class CollectItemsView implements GameEventView<CollectItemsEvent> {
    @Override
    public void render(CollectItemsEvent event) {
        Map<ItemType, Integer> items = event.items();
        System.out.println("The items that you collected from the chest are: ");

        items.forEach((key, value) -> System.out.println(value +
                "X " + key.getName()));
    }
}
