package sofia.sap.interview.project.game.view;

import sofia.sap.interview.project.game.events.ItemUnequipEvent;

public class ItemUnequipView implements GameEventView<ItemUnequipEvent> {
    @Override
    public void render(ItemUnequipEvent event) {
        String formatted = String.format("The %s you unequipped, decreased your attack damage with %d!",
                event.type().getName(), event.effect());
        System.out.println(formatted);
    }
}
