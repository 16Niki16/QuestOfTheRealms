package sofia.sap.interview.project.game.map.room;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.inventory.Chest;

import java.util.Collections;
import java.util.List;

public class Content {
    private final Chest chest;
    private final List<Enemy> enemies;

    private Content(List<Enemy> enemies, Chest chest) {
        this.chest = chest;
        this.enemies = enemies;
    }

    public static Content emptyRoom() {
        return new Content(Collections.emptyList(), Chest.createEmptyChest());
    }

    public static Content roomWithChest(Chest chest) {
        return new Content(Collections.emptyList(), chest);
    }

    public static Content roomWithEnemies(List<Enemy> enemies) {
        return new Content(enemies, Chest.createEmptyChest());
    }

    public static Content roomWithChestAndEnemies(List<Enemy> enemies, Chest chest) {
        return new Content(enemies, chest);
    }

    public void collectItems(Character character) {
        character.collectItems(this.chest);
    }
}

