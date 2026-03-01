package sofia.sap.interview.project.game.characters.ally.statistics;

public interface Statistics {
    boolean decreaseHealth(int amount);

    void increaseHealth(int amount);

    int attack();
}
