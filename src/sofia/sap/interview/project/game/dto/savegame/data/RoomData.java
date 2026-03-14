package sofia.sap.interview.project.game.dto.savegame.data;

import sofia.sap.interview.project.game.map.room.SpecialItem;

public class RoomData {
    private String name;
    private ChestData chest;
    private EnemyData enemy;
    private SpecialItem specialItem;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ChestData getChest() {
        return chest;
    }

    public void setChest(ChestData chest) {
        this.chest = chest;
    }

    public EnemyData getEnemy() {
        return enemy;
    }

    public SpecialItem getSpecialItem() {
        return specialItem;
    }

    public void setSpecialItem(SpecialItem specialItem) {
        this.specialItem = specialItem;
    }

    public void setEnemy(EnemyData enemy) {
        this.enemy = enemy;
    }
}
