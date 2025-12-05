package sofia.sap.interview.project.game.inventory.items.gear;

import sofia.sap.interview.project.game.exceptions.EquipException;
import sofia.sap.interview.project.game.inventory.items.Item;
import sofia.sap.interview.project.game.inventory.items.type.Type;

public class IronDagger extends Item implements Gear {
    private boolean equipped;

    public IronDagger() {
        super(Type.IRON_DAGGER);
        this.equipped = false;
    }

    @Override
    public int equip() {
        if (this.equipped) {
            throw new EquipException("The gear is already equipped!");
        }

        this.equipped = true;
        return getEffect();
    }

    @Override
    public int unequip() {
        if (!this.equipped) {
            throw new EquipException("The gear is already unequipped!");
        }

        this.equipped = false;
        return getEffect();
    }
}
