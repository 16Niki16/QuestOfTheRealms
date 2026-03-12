package sofia.sap.interview.project.game.dto.savegame.data;

import sofia.sap.interview.project.game.items.ItemType;

import java.util.Map;

public class ChestData {
    private Map<ItemType, Integer> items;

    public Map<ItemType, Integer> getItems() {
        return items;
    }

    public void setItems(Map<ItemType, Integer> items) {
        this.items = items;
    }
}
