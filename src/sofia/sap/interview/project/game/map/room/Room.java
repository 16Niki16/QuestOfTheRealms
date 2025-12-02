package sofia.sap.interview.project.game.map.room;

public class Room {
    private final int coordinateX;
    private final int coordinateY;
    private final Content content;

    public Room(int coordinateX, int coordinateY, Content content) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.content = content;
    }

}
