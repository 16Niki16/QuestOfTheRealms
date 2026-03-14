package sofia.sap.interview.project.game.dto.savegame.data;

public class PlaygroundData {
    private RoomData[][] rooms;

    public RoomData[][] getRoom() {
        return rooms;
    }

    public void setRoom(RoomData[][] rooms) {
        this.rooms = rooms;
    }
}
