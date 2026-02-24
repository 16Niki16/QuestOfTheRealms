package sofia.sap.interview.project.game.quests;

import sofia.sap.interview.project.game.events.CollectSpecialItemEvent;
import sofia.sap.interview.project.game.events.GameEvent;
import sofia.sap.interview.project.game.map.room.SpecialItem;

public class FindIronKey extends QuestBase {
    @Override
    public String questDescription() {
        return "Your quest is to find the iron key!";
    }

    @Override
    public void update(GameEvent event) {
        if (event instanceof CollectSpecialItemEvent e && e.getItemCollected().equals(SpecialItem.IRON_KEY)) {
            completeQuest();
        }
    }
}
