package sofia.sap.interview.project.game.dto.savegame.data;

import sofia.sap.interview.project.game.map.Coordinates;

public class MapData {
    private RoomData[][] rooms;
    private Coordinates coordinates;

    public RoomData[][] getRooms() {
        return rooms;
    }

    public void setRooms(RoomData[][] rooms) {
        this.rooms = rooms;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
