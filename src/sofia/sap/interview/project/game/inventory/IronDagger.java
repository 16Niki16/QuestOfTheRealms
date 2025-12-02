package sofia.sap.interview.project.game.inventory;

public class IronDagger extends Item implements Gear {
    private boolean equipped;

    public IronDagger(int effect) {
        super(effect);
        this.equipped = false;
    }

    @Override
    public void equip() {
        this.equipped = true;
    }

    @Override
    public void unequip() {
        this.equipped = false;
    }
}
