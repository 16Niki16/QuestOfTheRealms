package sofia.sap.interview.project.game.inventory.items.type;

public enum ItemType {
    IRON_DAGGER("iron dagger", 15, "attack damage"),
    HEALING_HERB("healing herb", 10, "health"),
    MANA_POTION("mana potion", 10, "mana");

    private final String name;
    private final int effect;
    private final String source;

    ItemType(String name, int effect, String source) {
        this.name = name;
        this.effect = effect;
        this.source = source;
    }

    public int getEffect() {
        return this.effect;
    }

    public String getSource() {
        return this.source;
    }
}
