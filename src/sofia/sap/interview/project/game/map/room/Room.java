package sofia.sap.interview.project.game.map.room;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.items.Item;

import java.util.Collection;

public class Room {
    private Enemy enemy;
    private Chest chest;
    private SpecialItem specialItem;

    public Room(Enemy enemy, Chest chest, SpecialItem specialItem) {
        this.enemy = enemy;
        this.chest = chest;
        this.specialItem = specialItem;
    }

    public Enemy getEnemy() {
        return this.enemy;
    }

    public Chest getChest() {
        return this.chest;
    }

    public SpecialItem getSpecialItem() {
        return this.specialItem;
    }

    public static Room emptyRoom() {
        return new Room(null, null, null);
    }

    public void collectItems(Character character) {
        Collection<Item> items = this.chest.collectItems();
        this.chest = null;
        character.collectItems(items);
    }

    public boolean hasEnemy() {
        return !(this.enemy == null);
    }

    public void killEnemy() {
        this.enemy = null;
    }

    public boolean hasChest() {
        return !(this.chest == null);
    }
}
