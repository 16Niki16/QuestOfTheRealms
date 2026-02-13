package sofia.sap.interview.project.game.map.room;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.inventory.Chest;

public record Room(Enemy enemy, Chest chest) {

    public static Room emptyRoom() {
        return new Room(null, null);
    }

    public static Room roomCreator(Enemy enemy, Chest chest) {
        return new Room(enemy, chest);
    }

    public void collectItems(Character character) {
        character.collectItems(this.chest);
    }

}
