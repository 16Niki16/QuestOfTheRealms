package sofia.sap.interview.project.game.gameplay.command;

import sofia.sap.interview.project.game.characters.ally.Character;

public class RunCommand implements Command {
    private Character character;

    public RunCommand(Character character) {
        this.character = character;
    }

    @Override
    public void execute() {

    }
}
