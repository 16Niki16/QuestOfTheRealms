package sofia.sap.interview.project.game.gameplay.command;

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
