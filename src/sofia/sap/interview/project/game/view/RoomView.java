package sofia.sap.interview.project.game.view;

import sofia.sap.interview.project.game.information.RoomInformation;

public class RoomView implements StatelessCommandView<RoomInformation> {
    @Override
    public void render(RoomInformation information) {
        System.out.println("At your destination you found:");
        if (information.hasChest()) {
            System.out.println("- Chest");
        }
        if (information.enemy() != null) {
            System.out.println("Enemy: " + information.enemy().getName());
        }
        if (information.item() != null) {
            System.out.println("Special item: " + information.item().getName());
        }
    }
}
