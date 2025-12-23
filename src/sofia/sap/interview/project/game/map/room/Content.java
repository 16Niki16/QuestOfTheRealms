package sofia.sap.interview.project.game.map.room;

import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.inventory.Chest;

import java.util.Collections;
import java.util.List;

public class Content {
    private final Chest chest;
    private final List<Enemy> enemies;

    public Content(List<Enemy> enemies, Chest chest) {
        this.chest = chest;
        this.enemies = enemies;
    }

    public Content(List<Enemy> enemies) {
        this.enemies = enemies;
        this.chest = null;
    }

    public Content(Chest chest) {
        this.chest = chest;
        this.enemies = Collections.emptyList();
    }

    public Content() {
        this.chest = null;
        this.enemies = Collections.emptyList();
    }
}
