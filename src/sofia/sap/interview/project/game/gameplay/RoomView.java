package sofia.sap.interview.project.game.gameplay;

import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.map.room.SpecialItem;

public record RoomView(boolean hasChest, Enemy enemy, SpecialItem item) {
}
