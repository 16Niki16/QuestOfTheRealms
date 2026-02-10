package sofia.sap.interview.project.game.command;

public class InputHandler {
    private final CommandFactory factory;
    private final Controller controller;

    public InputHandler(CommandFactory factory, Controller controller) {
        this.factory = factory;
        this.controller = controller;
    }

}
