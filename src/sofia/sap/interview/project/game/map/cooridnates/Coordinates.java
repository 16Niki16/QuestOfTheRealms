package sofia.sap.interview.project.game.map.cooridnates;

public record Coordinates(int x, int y) {
    public static Coordinates startingCoordinates() {
        return new Coordinates(0, 0);
    }
}
