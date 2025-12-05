package sofia.sap.interview.project.game.inventory.items.type;

public enum Type {
    IRON_DAGGER("Iron dagger", 15),
    HEALING_HERB("Healing herb", 10),
    MANA_POTION("Mana potion", 10);

    private String name;
    private int effect;

    Type(String name, int effect) {
        this.name = name;
        this.effect = effect;
    }

    public String getName() {
        return this.name;
    }

    public int getEffect() {
        return this.effect;
    }
}
