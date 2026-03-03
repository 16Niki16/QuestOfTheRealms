package sofia.sap.interview.project.game.view;

import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.map.room.SpecialItem;

public record RoomInformation(boolean hasChest, Enemy enemy, SpecialItem item) implements ViewInformation {

}
