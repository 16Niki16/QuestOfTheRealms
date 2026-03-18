package sofia.sap.interview.project.game.command;

public enum CommandOptions {
    ATTACK("attack"),
    USE_ITEM("use"),
    LOOK("look"),
    MOVE("move"),
    EQUIP("equip"),
    UNEQUIP("unequip"),
    HELP("help"),
    QUESTS("quests"),
    PATHS("paths"),
    OPEN("open");
    private final String command;

    CommandOptions(String command) {
        this.command = command;
    }

    public String getCommand() {
        return this.command;
    }
}
