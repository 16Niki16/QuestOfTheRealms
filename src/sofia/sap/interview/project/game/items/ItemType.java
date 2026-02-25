package sofia.sap.interview.project.game.items;

import sofia.sap.interview.project.game.exceptions.ItemNotAvailableException;

public enum ItemType {
    MANA_POTION("mana potion"),
    HEALING_HERB("healing herb"),
    IRON_DAGGER("iron dagger");

    private final String name;

    ItemType(String name) {
        this.name = name;
    }

    public static ItemType getByName(String itemName) {
        for (ItemType type : values()) {
            if (type.name.equals(itemName)) {
                return type;
            }
        }
        throw new ItemNotAvailableException("The provided item is not available!");
    }
}
