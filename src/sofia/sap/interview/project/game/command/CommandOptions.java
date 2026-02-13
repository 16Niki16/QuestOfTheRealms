package sofia.sap.interview.project.game.command;

import sofia.sap.interview.project.game.exceptions.CommandNotAvailableException;

public enum CommandOptions {
    ATTACK("attack"),
    DEFEND("defend"),
    USE_ITEM("use"),
    LOOK("look"),
    MOVE("move"),
    EQUIP("equip"),
    UNEQUIP("unequip"),
    HELP("help");
    private final String command;

    CommandOptions(String command) {
        this.command = command;
    }

    public static CommandOptions getOption(String command) {
        for (CommandOptions option : values()) {
            if (option.command.equals(command)) {
                return option;
            }
        }
        throw new CommandNotAvailableException("The provided command line is not available!");
    }
}
