package sofia.sap.interview.project.game.inventory.items.type;

public enum ItemType {
    IRON_DAGGER("Iron dagger", 15),
    HEALING_HERB("Healing herb", 10),
    MANA_POTION("Mana potion", 10);

    private final String name;
    private final int effect;

    ItemType(String name, int effect) {
        this.name = name;
        this.effect = effect;
    }

    public int getEffect() {
        return this.effect;
    }
}
