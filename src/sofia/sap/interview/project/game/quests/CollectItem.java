package sofia.sap.interview.project.game.quests;

import sofia.sap.interview.project.game.events.GameEvent;
import sofia.sap.interview.project.game.inventory.Item;

public class CollectManaPotion extends QuestBase {
    private Item item;

    public CollectItem(String description) {
        super(description);
        this.item = Item.MANA_POTION;
    }

    @Override
    public void update(GameEvent event) {

    }
}
