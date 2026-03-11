package sofia.sap.interview.project.game.dto.savegame;

public class RoomData {
    private ChestData chest;
    private EnemyData enemy;
    private String specialItem;

    public ChestData getChest() {
        return chest;
    }

    public void setChest(ChestData chest) {
        this.chest = chest;
    }

    public EnemyData getEnemy() {
        return enemy;
    }

    public String getSpecialItem() {
        return specialItem;
    }

    public void setSpecialItem(String specialItem) {
        this.specialItem = specialItem;
    }

    public void setEnemy(EnemyData enemy) {
        this.enemy = enemy;
    }
}
