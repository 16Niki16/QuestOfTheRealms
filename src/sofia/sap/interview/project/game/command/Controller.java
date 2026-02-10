package sofia.sap.interview.project.game.command;

import sofia.sap.interview.project.game.command.commands.Command;

public class Controller {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeClientCommand() {
        if (command != null) {
            command.execute();
        }
    }
}
