package sofia.sap.interview.project.game.map.room;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.inventory.Chest;

public class Room {
    private final Chest chest;
    private final Enemy enemy;

    public Room(Enemy enemy, Chest chest) {
        this.chest = chest == null ? Chest.createEmptyChest() : chest;
        this.enemy = enemy;
    }

    public static Room emptyRoom() {
        return new Room(null, Chest.createEmptyChest());
    }

    public static Room roomCreator(Enemy enemy, Chest chest) {
        return new Room(enemy, chest);
    }

    public void collectItems(Character character) {
        character.collectItems(this.chest);
    }

    public Enemy getEnemy() {
        return this.enemy;
    }

}
