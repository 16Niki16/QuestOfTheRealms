package sofia.sap.interview.project.game.map.room;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.inventory.Chest;

import java.util.Collections;
import java.util.List;

public class Room {
    private final Chest chest;
    private final List<Enemy> enemies;

    public Room(List<Enemy> enemies, Chest chest) {
        this.chest = chest == null ? Chest.createEmptyChest() : chest;
        this.enemies = enemies == null ? Collections.emptyList() : enemies;
    }

    public static Room emptyRoom() {
        return new Room(Collections.emptyList(), Chest.createEmptyChest());
    }

    public static Room roomCreator(List<Enemy> enemies, Chest chest) {
        return new Room(enemies, chest);
    }

    public void collectItems(Character character) {
        character.collectItems(this.chest);
    }

    public List<Enemy> getEnemies() {
        return this.enemies;
    }

}
