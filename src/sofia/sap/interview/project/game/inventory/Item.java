package sofia.sap.interview.project.game.inventory;

import sofia.sap.interview.project.game.exceptions.ItemNotAvailableException;

public enum Item {
    IRON_DAGGER("iron dagger", 15, "attack damage", true),
    HEALING_HERB("healing herb", 10, "health", false),
    MANA_POTION("mana potion", 10, "mana", false);

    private final String name;
    private final int effect;
    private final String source;
    private final boolean equip;

    Item(String name, int effect, String source, boolean equip) {
        this.name = name;
        this.effect = effect;
        this.source = source;
        this.equip = equip;
    }

    public int getEffect() {
        return this.effect;
    }

    public String getSource() {
        return this.source;
    }

    public static Item getItem(String item) {
        for (Item type : values()) {
            if (type.name.equals(item)) {
                return type;
            }
        }
        throw new ItemNotAvailableException("The provided item is not available!");
    }

}
