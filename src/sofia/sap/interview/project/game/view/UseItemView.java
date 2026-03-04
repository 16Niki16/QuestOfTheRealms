package sofia.sap.interview.project.game.view;

import sofia.sap.interview.project.game.events.ItemUsedEvent;

public class UseItemView implements GameEventView<ItemUsedEvent> {
    @Override
    public void render(ItemUsedEvent event) {
        String formatted = String.format("The %s potion granted you with %d %s!",
                event.type().getName(), event.effect(), event.type().getSource());
        System.out.println(formatted);
    }
}
