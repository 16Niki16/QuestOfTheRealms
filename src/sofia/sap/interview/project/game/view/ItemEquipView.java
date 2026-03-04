package sofia.sap.interview.project.game.view;

import sofia.sap.interview.project.game.events.ItemEquipEvent;

public class ItemEquipView implements GameEventView<ItemEquipEvent> {

    @Override
    public void render(ItemEquipEvent event) {
        String formatted = String.format("The %s you equipped, granted you with %d attack damage!",
                event.type().getName(), event.effect());
        System.out.println(formatted);
    }
}
