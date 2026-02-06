package sofia.sap.interview.project.game.gameplay;

public enum CombatOptions {
    ATTACK("attack"),
    DEFEND("defend"),
    USE_ITEM("use"),
    RUN("run"),
    LOOK("look"),
    MOVE("move");
    private final String command;

    CombatOptions(String command) {
        this.command = command;
    }

}
