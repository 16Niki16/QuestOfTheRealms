package sofia.sap.interview.project.game.view;

import sofia.sap.interview.project.game.events.CollectSpecialItemEvent;
import sofia.sap.interview.project.game.map.room.SpecialItem;

public class CollectSpecialItemView implements GameEventView<CollectSpecialItemEvent> {
    @Override
    public void render(CollectSpecialItemEvent event) {
        SpecialItem item = event.item();
        String formatted = String.format("Congrats you found the special item %s!", item.getName());
        System.out.println(formatted);
    }
}
