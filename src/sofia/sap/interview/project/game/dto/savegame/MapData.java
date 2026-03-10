package sofia.sap.interview.project.game.dto.savegame;

public class MapData {
    private RoomData[][] rooms;
    private int characterX;
    private int characterY;

    public RoomData[][] getRooms() {
        return rooms;
    }

    public void setRooms(RoomData[][] rooms) {
        this.rooms = rooms;
    }

    public int getCharacterX() {
        return characterX;
    }

    public void setCharacterX(int characterX) {
        this.characterX = characterX;
    }

    public int getCharacterY() {
        return characterY;
    }

    public void setCharacterY(int characterY) {
        this.characterY = characterY;
    }
}
