package sofia.sap.interview.project.game.map.room;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.map.room.items.SpecialItem;

public record Room(Enemy enemy, Chest chest, SpecialItem item) {

    public static Room emptyRoom() {
        return new Room(null, null, null);
    }

    public static Room roomCreator(Enemy enemy, Chest chest, SpecialItem item) {
        return new Room(enemy, chest, item);
    }

    public void collectItems(Character character) {
        character.collectItems(this.chest);
    }

}
