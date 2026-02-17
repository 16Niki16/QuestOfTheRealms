package sofia.sap.interview.project.game.quests;

import sofia.sap.interview.project.game.events.CollectItemEvent;
import sofia.sap.interview.project.game.events.GameEvent;
import sofia.sap.interview.project.game.map.room.items.SpecialItem;

public class FindIronKey extends QuestBase {
    @Override
    public String questDescription() {
        return "Your quest is to find the iron key!";
    }

    @Override
    public void update(GameEvent event) {
        if (event instanceof CollectItemEvent e && e.getItemCollected().equals(SpecialItem.IRON_KEY)) {
            completeQuest();
        }
    }
}
