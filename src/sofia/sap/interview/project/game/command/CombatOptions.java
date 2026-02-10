package sofia.sap.interview.project.game.command;

import sofia.sap.interview.project.game.exceptions.CommandNotAvailableException;

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

    public static CombatOptions getOption(String command) {
        for (CombatOptions option : values()) {
            if (option.command.equals(command)) {
                return option;
            }
        }
        throw new CommandNotAvailableException("The provided command line is not available!");
    }
}
